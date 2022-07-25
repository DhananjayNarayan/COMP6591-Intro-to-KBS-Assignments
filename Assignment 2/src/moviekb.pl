
:- dynamic(movie/7).
:- dynamic(actor/4).
:- dynamic(movie_actor/2).

movie('tt7144666','The Black Phone',thriller,2021,7.3,[phone,murder,call,kidnapper,kids,ghost,survival,kidnap],[english]).
movie('tt10709484','Don',drama,2022,7.0,[don,love,rowdy,sivakarthikeyan,ambition,goal,chechi],[tamil,telugu]).
movie('tt9851854','Major',thriller,2022,8.6,[patriotism,sacrifice,war,martyr,love],[telugu,tamil]).
movie('tt8960382','Radhe Shyam',romance,2022,5.3,[love,destiny,prediction,future,premonition],[telugu]).
movie('tt2631186','Baahubali',drama,2015,8.0,[kings,throne,fight,war,love,revenge,flashback],[telugu]).
movie('tt5440700','Theri',thriller,2016,7.3,[daughter,kidnap,love,death,revenge],[tamil]).
movie('tt1825683','Black Panther',drama,2018,7.3,[revenge,flashback,throne,king,war],[english]).
movie('tt10545484','Evaru',thriller,2019,8.2,[revenge,flashback,murder,spy,trauma,war],[telugu]).
movie('tt11301946','Beast',thriller,2022,5.2,[hero,army,dance,hijack,mall],[tamil,telugu]).
movie('tt1649303','Darling',romance,2010,7.3,[love,funny,dance,cheat,flashback],[telugu]).
movie('tt1922777','Sinister',thriller,2012,6.8,[ghost,father,haunted,family,exorcism],[english]).
movie('tt6148156','Vikram Vedha',drama,2017,8.2,[revenge,love,gangster,cop,murder,conspiracy],[tamil]).
movie('tt9263550','Rocketry',drama,2022,9.3,[truestory,sad,conspiracy,patriotism],[tamil]).
movie('tt8178634','RRR',drama,2022,8.0,[patriotism,hero,brothers,dance,love],[telugu]).
movie('tt6836936','Saaho',drama,2019,5.0,[cop,thief,burglary,love,cheat],[telugu]).
movie('tt11374902','Doctor',thriller,2021,7.5,[kidnap,crime,love,baby,chellama],[tamil]).
movie('tt1191121','Jalsa',romance,2008,7.4,[love,impress,dance,musical,breakup],[telugu]).
movie('tt5959980','Vada Chennai',drama,2018,8.4,[crime,muder,thief,guns,war,violence],[tamil]).
movie('tt9900782','Kaithi',thriller,2019,8.5,[smuggling,drugs,war,biryani,multiverse,police,chase],[tamil]).
movie('tt3863552','Bajrangi Bhaijaan',drama,2015,8.1,[chicken,pakistan,india,kid,child,reunion],[telugu]).


actor('nm1659141','Prabhas',male ,43).
actor('nm5249562','Pooja Hegde',female,32).
actor('nm1912683','Karthi',male ,45).
actor('nm0000160','Ethan Hawke',male ,52).
actor('nm3414188','Adivi Sesh',male ,37).
actor('nm2281292','Rana Daggubati',male ,38).
actor('nm2011932','Anushka Shetty',female,41).
actor('nm1694524','NTR',male ,38).
actor('nm2776304','Ram Charan',male ,37).
actor('nm0006795','Salman Khan',male ,57).
actor('nm0534856','Madhavan',male ,52).
actor('nm0004626','Kareena Kapoor',female,42).
actor('nm0897201','Joseph Vijay',male ,52).
actor('nm3606487','Samantha Ruth Prabhu',female,35).
actor('nm3367112','Amy Jackson',female,30).
actor('nm6489058','Yogi Babu',male ,45).
actor('nm3601766','Shraddha Kapoor',female,36).
actor('nm1302330','Murli Sharma',male ,53).
actor('nm1017633','Alia Bhatt',female,32).
actor('nm2570245','Kajal Aggarwal',female,37).
actor('nm0436302','Pawan Kalyan',male ,52).
actor('nm9296746','Mason Thames',male ,15).
actor('nm6421259','Madeleine McGraw',female,14).
actor('nm10484501','Priyanka Arulmohan',female,27). 
actor('nm2284321','Samuthirakani',male ,52).
actor('nm4792434','Sivakarthikeyan',male ,36).
actor('nm0695177','Prakash Raj',male ,59).
actor('nm1569276','Chadwick Boseman',male ,43).
actor('nm1775091','Danai Gurira',female,35).
actor('nm0293509','Martin Freeman',male ,51).
actor('nm5294556','Regina Cassandra',female,32).
actor('nm0694893','Prabhu',male ,65).
actor('nm1628115','Juliet Rylance',female,32).
actor('nm0710447','James Ransone',male ,36).
actor('nm4043111','Vijay Sethupathi',male ,50).
actor('nm7744845','Shraddha Srinath',female,30).
actor('nm0451321','Shah Rukh Khan',male ,58).
actor('nm0801264','Simran',female,45).
actor('nm0103977','Brahmanandam',male ,68).
actor('nm1333687','Dhanush',male ,49).
actor('nm5781594','Aishwarya Rajesh',female,30).
actor('nm10183124','Arjun Das',male ,28).
actor('nm1230844','Narain',male ,42).
actor('nm7372970','Harshaali Malhotra',female,14).


genre(romance).
genre(drama).
genre(thriller).

language(english).
language(telugu).
language(tamil).

%TheBlackPhone
movie_actor('tt7144666','nm0000160').
movie_actor('tt7144666','nm9296746').
movie_actor('tt7144666','nm6421259').

%Don
movie_actor('tt10709484','nm4792434').
movie_actor('tt10709484','nm10484501').
movie_actor('tt10709484','nm2284321').

%Major
movie_actor('tt9851854','nm3414188').
movie_actor('tt9851854','nm0695177').
movie_actor('tt9851854','nm1302330').
 
%Radhe Shyam
movie_actor('tt8960382','nm1659141').
movie_actor('tt8960382','nm5249562').
movie_actor('tt8960382','nm1302330').

%Baahubali
movie_actor('tt2631186','nm1659141').
movie_actor('tt2631186','nm2281292').
movie_actor('tt2631186','nm2011932').

%Theri
movie_actor('tt5440700','nm0897201').
movie_actor('tt5440700','nm3606487').
movie_actor('tt5440700','nm3367112').

%BlackPanther
movie_actor('tt1825683','nm1569276').
movie_actor('tt1825683','nm1775091').
movie_actor('tt1825683','nm0293509').
 
%Evaru
movie_actor('tt10545484','nm3414188').
movie_actor('tt10545484','nm1302330').
movie_actor('tt10545484','nm5294556').

%Beast
movie_actor('tt11301946','nm0897201').
movie_actor('tt11301946','nm5249562').
movie_actor('tt11301946','nm6489058').

%Darling
movie_actor('tt1649303','nm1659141').
movie_actor('tt1649303','nm2570245').
movie_actor('tt1649303','nm0694893').

%Sinister
movie_actor('tt1922777','nm0000160').
movie_actor('tt1922777','nm1628115').
movie_actor('tt1922777','nm0710447').

%VikramVedha
movie_actor('tt6148156','nm0534856').
movie_actor('tt6148156','nm4043111').
movie_actor('tt6148156','nm7744845').

%Rocketry
movie_actor('tt9263550','nm0534856').
movie_actor('tt9263550','nm0801264').
movie_actor('tt9263550','nm0451321').

%RRR
movie_actor('tt8178634','nm1694524').
movie_actor('tt8178634','nm2776304').
movie_actor('tt8178634','nm1017633').

%Saaho
movie_actor('tt6836936','nm1659141').
movie_actor('tt6836936','nm3601766').
movie_actor('tt6836936','nm1302330').

%Doctor
movie_actor('tt11374902','nm4792434').
movie_actor('tt11374902','nm10484501').
movie_actor('tt11374902','nm6489058').

%Jalsa
movie_actor('tt1191121','nm0436302').
movie_actor('tt1191121','nm0695177').
movie_actor('tt1191121','nm0103977').

%VadaChennai
movie_actor('tt5959980','nm1333687').
movie_actor('tt5959980','nm5781594').
movie_actor('tt5959980','nm2284321').

%Kaithi
movie_actor('tt9900782','nm1912683').
movie_actor('tt9900782','nm10183124').
movie_actor('tt9900782','nm1230844').

%BajrangiBhaijaan
movie_actor('tt3863552','nm0006795').
movie_actor('tt3863552','nm0004626').
movie_actor('tt3863552','nm7372970').


ismember(X, [X|_]).
ismember(X, [_|T]) :- ismember(X, T).


check_language([]). 
check_language([H|T]):-  language(H),
                         check_language(T). 

add_movie(ID,N,G,Y,R,KW,LAN):- write('Adding the movie'),
                           genre(G),                         
                           check_language(LAN),
                           length(KW,NUM),
                           NUM >= 5,                         
                           \+ movie(ID,_,_,_,_,_,_),
                           assertz(movie(ID,N,G,Y,R,KW,LAN)).
                            
update_movie_title(ID,NEWTITLE):- write('Updating Movie Title'),
                               retract(movie(ID,_,G,Y,R,KW,LAN)),
                               assertz(movie(ID,NEWTITLE,G,Y,R,KW,LAN)).

update_movie_genre(ID,NEWGENRE):- write('Updating Movie Genre'),
                               retract(movie(ID,N,_,Y,R,KW,LAN)),
                               genre(NEWGENRE),
                               assertz(movie(ID,N,NEWGENRE,Y,R,KW,LAN)).

update_movie_rating(ID,NEWRATING):- write('Updating Movie Rating'),
                               retract(movie(ID,N,G,Y,_,KW,LAN)),
                               assertz(movie(ID,N,G,Y,NEWRATING,KW,LAN)).

update_movie_year(ID,NEWYEAR):- write('Updating Movie Year'),
                              retract(movie(ID,N,G,_,R,KW,LAN)),
                               assertz(movie(ID,N,G,NEWYEAR,R,KW,LAN)).


update_movie_keywords(ID,NEWKW):- write('Updating Movie Keywords'),
                               length(NEWKW,NUM),
                               NUM >= 5, 
                               retract(movie(ID,N,G,Y,R,_,LAN)),
                               assertz(movie(ID,N,G,Y,R,NEWKW,LAN)).

update_movie_languages(ID,NEWLANGUAGE):- write('Updating Movie Languages'),
                               check_language(NEWLANGUAGE),
                               retract(movie(ID,N,G,Y,R,KW,_)),
                               assertz(movie(ID,N,G,Y,R,KW,NEWLANGUAGE)).




delete_movie(ID):- write('Deleting the Movie'),
                   retract(movie(ID,_,_,_,_,_,_)).


add_actor(ID,N,G,A):- write('Adding New Actor'),
                    \+ actor(ID,_,_,_),
                      assertz(actor(ID,N,G,A)).

update_actor_name(ID,NEWNAME):- write('Updating the actor name'),
                                retract(actor(ID,_,G,A)),
                                assertz(actor(ID,NEWNAME,G,A)).

update_actor_gender(ID,NEWGENDER):-write('Updating the actor gender'),
                       retract(actor(ID,N,_,A)),
                       assertz(actor(ID,N,NEWGENDER,A)).

update_actor_age(ID,NEWAGE):- write('Updating the actor age'),
                                retract(actor(ID,N,G,_)),
                                assertz(actor(ID,N,G,NEWAGE)).

delete_actor(ID):- write('Deleting the Actor'),
                   retract(actor(ID,_,_,_)).


add_movie_actor(MID,AID):- write('Mapping Movie to Actor'),
                           assertz(movie_actor(MID,AID)).


find_a_movie(X,L):- findall([ID,M],(movie(ID,M,_,_,_,_,_),atom_concat(X,_,M)),L),
                   write(L).


catAsuccess(L):- write('All S are P : All movie has Actors'),
          
          findall([S,A],(movie(ID,S,_,_,_,_,_),movie_actor(ID,P),actor(P,A,_,_)),L).
          %write(L)

catAfail(L):- write('All S are P : All movie has Actors. '),
          write('Finding movies without actors. Should return empty list,indicating failure to find so.'),
          findall([S,A],(movie(ID,S,_,_,_,_,_),movie_actor(ID,''),actor(_,A,_,_)),L).

catEsuccess(L,L1):- write('No S are P : No movie has language Malayalam'),
         findall([M,L],(movie(_,M,_,_,_,_,L)),L1).


catEfail(L,L1):- write('No S are P : No movie has language Malayalam. To show its failure, we are searching for a movie with a known/valid language - english.'),
         findall([M,L],(movie(_,M,_,_,_,_,L)),L1).
        

catIsuccess(G,L1):- write('Some S are P : Some movies are Thriller. '),
                 findall([M,G],(movie(_,M,G,_,_,_,_)),L1).



catIfail(L1):- write('Some S are P : Some movies are Thriller. To show its fail condition, we are showing movies with genres other than thriller '),
               findall([M,G],(movie(_,M,G,_,_,_,_), (G \= thriller)),L1).              

catOsuccess(L):- write('Some S are not P' : 'Some movies do not have good rating. '),
                write('Searching for movies having ratings lesser than 8. '),
                findall([M,R],(movie(_,M,_,_,R,_,_),R < 8.0),L).

catOfail(L) :- write('Some S are not P' : 'Some movies do not have good rating. '),
                  write('Searching for movies having ratings greater than 8. '),
                findall([M,R],(movie(_,M,_,_,R,_,_),R > 8.0),L).
