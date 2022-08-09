package com.company.lib;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ProgramParser {
    public static Clause[] parseKB(InputStream input) throws IOException {
        byte[] buf = new byte[input.available()];
        input.read(buf, 0, buf.length);
        String[] lines = new String(buf).split("[\\.|\\n]");
        return Arrays.stream(lines)
                .filter(l -> l.trim().length() > 0)
                .map(Clause::parse)
                .toArray(Clause[]::new);
    }
}