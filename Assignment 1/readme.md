# Assignment 1 - Knowledge Base in SQLite and Prolog

### Submitted By :
Dhananjay Narayan (40164521)
</br>
Madhuvanthi Hemanathan (40181308)

## SQL Queries

- Open Command Prompt and the destination folder, type sqlite3 assignment1

-Query 1 :  Search for a movie title.
            
    select * from movie where title == "Don";
            
-Query 2 :  list all movie titles.

    select title from movie;
            
 -Query 3 :  list all movies played by an actor.

    select distinct m.* from movie m JOIN movie_actor ma on m.id = ma.movie_id JOIN actor a on a.id = ma.actor_id where a.name == "Sivakarthikeyan"; 
            
 -Query 4 : list all distinct movies played by two given actors.
    
    select distinct m.* from movie m JOIN movie_actor ma on m.id = ma.movie_id
	join actor a on a.id = ma.actor_id 
    where a.name == "Priyanka Arulmohan" or a.name=="Sivakarthikeyan"
    group By ma.movie_id having count(ma.movie_id) >= 2;
    
-To Verify print their movies individually:
    
    select distinct * from movie m JOIN movie_actor ma on m.id = ma.movie_id JOIN actor a on a.id = ma.actor_id where a.name == "Sivakarthikeyan"; 
    
    select distinct * from movie m JOIN movie_actor ma on m.id = ma.movie_id JOIN actor a on a.id = ma.actor_id where a.name == "Priyanka Arulmohan";
    
 -Query 5 : list all distinct movies played by either of two given actors.
 
    select distinct m.* from movie m JOIN movie_actor ma on m.id = ma.movie_id JOIN actor a on a.id = ma.actor_id 
    where a.name == "Sivakarthikeyan" or a.name == "Priyanka Arulmohan";
 
 -Query 6 : list all distinct movies played by some actor within a list of years.
    
    select distinct m.* from movie m JOIN movie_actor ma on m.id = ma.movie_id JOIN actor a on a.id = ma.actor_id 
    where a.name == "Sivakarthikeyan" and m.release_year in (2022,2014,2021);
 
 -Query 7 : list movie ids, and titles sorted by id.
    
    select id, title from movie order by id asc;
 
 -Query 8 : list movie ids, and titles sorted by title.
 
    select id, title from movie order by title asc;


## Prolog Queries

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
    



