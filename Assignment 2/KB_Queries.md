## Prolog Queries to Demonstrate Use of KB

-Open the prolog editor and to compile type 

    consult('moviekb.pl'). 

-Query: Adding Movies

    add_movie('tt3175038','Ek Villain',thriller,2014,6.5,[murder,villain,jealous],[telugu,tamil]).
    add_movie('tt11947158','Ek Villain 2',thriller,2022,7.5,[murder,villain,jealous],[tamil,telugu]).
    movie(_,'Baahubali',_,_,_,_,_,_).

-Query 2 : list all movie titles.

 (i) For returning movies individually
 
    movie(_,X,_,_,_,_,_,_).
 (ii) For returning movies as a list
 
    findall(M,movie(_,M,_,_,_,_,_,_),L).
      
 -Query 3 : list all movies played by an actor.
 
 
    list_movies_played_by_actor('Prabhas').
   
 -Query 4 : list all distinct movies played by two given actors.
 
 
    distinct_movies_by_actors('Sivakarthikeyan','Priyanka Arulmohan').
   
 -Query 5 : list all distinct movies played by either of two given actors.
 
 
    distinct_movies_by_either_two_actors('Sivakarthikeyan','Prabhas').
   
 -Query 6 : list all distinct movies played by some actor within a list of years.
 
 
    movie_by_actor_year('Prabhas',[2022,2015]). 
    
 -Query 7 : list movie ids, and titles sorted by id.
 
    sort_by_id(X).
    
 -Query 8 : list movie ids, and titles sorted by title.
 
    sort_by_title(L).
    



