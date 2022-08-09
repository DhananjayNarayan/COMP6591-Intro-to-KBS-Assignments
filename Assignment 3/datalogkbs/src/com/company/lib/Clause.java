/*
 *  TermInfo.java
 *
 *  This utility class provides simplified Prolog parser using JPL.
 *
 *  (C) 2022 Ali Jannatpour <ali.jannatpour@concordia.ca>
 *
 *  This code is licensed under GPL.
 *
 */

package com.company.lib;

import org.jpl7.*;

import java.util.*;
import java.util.stream.Collectors;

public class Clause {

    public enum TYPE { RULE, PROC, ATOM, UNKNOWN };

    private Term t;

    private Clause(Term t) {
        this.t = t;
    }

    public static Clause parse(String text) {
        return new Clause(Term.textToTerm(text));
    }

    Term getJPLTerm() {
        return this.t;
    }

    public TYPE getType() {
        return this.isRule()? TYPE.RULE: this.isProc()? TYPE.PROC: this.isAtom()? TYPE.ATOM: TYPE.UNKNOWN;
    }

    public boolean isRule() {
        return t.isCompound() && t.name().compareTo(":-") == 0;
    }

    public boolean isProc() {
        return !isRule() && t.isCompound();
    }

    public boolean isAtom() {
        return this.t.isAtom();
    }

    public boolean isVariable() {
        return this.t.isVariable();
    }

    public Clause getHead() {
        return !isRule() ? null : new Clause(((Compound)t).args()[0]);
    }

    public String[] getVariables() {
        if(!this.t.isCompound()) return null;
        ArrayList<String> result = new ArrayList<>();
        for (Term t: this.t.args()) {
            if(t.isVariable()) {
                result.add(t.name());
            }
            else {
                    result.addAll(List.of(new Clause(t).getVariables()));
            }
        }
        return new LinkedHashSet<>(result).toArray(String[]::new);
    }

    public String substitute(HashMap<String, Object> vars) {
        if(this.t.isCompound())
            return substitute((Compound)this.t, new MultiValueMap(vars)).toString();
        if(this.t.isVariable())
            return vars.containsKey(this.t.name()) ? vars.get(this.t.name()).toString(): this.t.toString();
        return null;
    }

    public String getName() {
        return this.t.name();
    }

    public Clause[] getGoals() {
        if(!isRule())
            return null;
        return flatten(t.args()[1]).stream().map(t -> new Clause(t)).collect(Collectors.toList()).toArray(Clause[]::new);
    }

    public Clause[] getArgs() {
        if(!isProc())
            return null;
        return Arrays.stream(t.args()).map(t -> new Clause(t)).collect(Collectors.toList()).toArray(Clause[]::new);
    }

    @Override
    public String toString() {
        return !this.isRule()? this.t.toString():
            String.format("%s :- %s", this.getHead().toString(),
                    Arrays.toString(this.getGoals()).
                            replaceFirst("^\\[", "").
                            replaceFirst("\\]$", ""));
    }

    private ArrayList<Term> flatten(Term... terms) {
        ArrayList<Term> result = new ArrayList<>();
        for (Term t: terms) {
            if(t.isCompound() && t.name().compareTo(",") == 0)
                result.addAll(flatten(t.args()));
            else
                result.add(t);
            }
        return result;
    }

    private Compound substitute(Compound c, MultiValueMap vars) {
        ArrayList<Term> result = new ArrayList<>();
        for (Term t: c.args()) {
            if(t.isCompound())
                result.add(substitute((Compound)t, vars));
            else if(t.isVariable()) {
                if(vars.containsKey(t.name())) {
                    Object val = vars.get(t.name());
                    if(val.getClass() == java.lang.Integer.class)
                        result.add(new org.jpl7.Integer((java.lang.Integer)val));
                    else if(val.getClass() == java.lang.Float.class)
                        result.add(new org.jpl7.Float((java.lang.Integer)val));
                    else
                        result.add(new Atom(val.toString()));
                }
                else
                    result.add(t);
            }
        }
        return new Compound(c.name(), result.toArray(Term[]::new));
    }
}
