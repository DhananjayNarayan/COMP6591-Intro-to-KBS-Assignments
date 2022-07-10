## Assignment 1 - Knowledge Base in SQLite and Prolog

#Submitted By :
Dhananjay Narayan (40164521)
Madhuvanthi Hemanathan ()


#Prolog Queries

-Open the prolog editor and to compilte type 
consult('moviekb.pl'). 

-Query 1 : Search for a movie title.

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
    



