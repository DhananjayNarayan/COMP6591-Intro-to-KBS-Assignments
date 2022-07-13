# Assignment 1 - Knowledge Base in SQLite and Prolog

### Submitted By :
Dhananjay Narayan (40164521)
</br>
Madhuvanthi Hemanathan (40181308)

## SQL Queries

- Open Command Prompt and goto the destination folder db, type sqlite3 assignment1

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
    
    
## Verification Queries

-Verification 1 : The data-set must include at least 10 titles.

	select IIF(count(DISTINCT title) >= 10, 'minimum of 10 movie titles validated', 'does not have 	minimum of 10 movie titles') as validation,
	count(DISTINCT title) as counts_found from movie;
	

-Verification 2 : The data-set must include at least two movies with more than one language.

	   select iif(count(id) >= 2, 
           'true: Data set includes at least two movies with more than one language',
           'false: Data set does not include at least two movies with more than one language'
          ) as validation from (
            select id,title,languages from movie GROUP by id 
            HAVING (length(languages) - length(REPLACE(languages, ',', '')) + 1) >= 2
          );
	  
	  
	  
-Verification 3: At least 3 cast members per movie must be included. (Showing movies which has cast less than 3)


	select iif(count(*) > 0, 
           'false: Data set does not include at least three cast members per movie',
		'true: Data set includes at least three cast members per movie'
          ) as validation from (
            select movie_id from movie_actor group by movie_id having count(*) < 3
          );



-Verification 4: There must exist a movie with no director or writer info.


	select iif(count(*) >= 1, 
           'true: There exists a movie with no director or writer info',
           'false: There are no movies without director or writer info'
          ) as validation from (
            select m.* from movie m where m.id not in (select distinct movie_id from movie_director)
          );



-Verification 5: Include at least 5 keywords per movie. Make sure some movies share one or two keywords.

		Keyword count violation:

		select iif(count(*) > 0, 
		   'true: There exists a movie with less than 5 keywords',
		   'false: There are no movies with less than 5 keywords'
		  ) as validation from (
		    select id, keywords from movie GROUP by id 
			 HAVING length(keywords) - length(REPLACE(keywords, ',', '')) + 1 < 5 or length(keywords) is NULL
		  );


		keyword count:

		select id, keywords, length(keywords) - length(REPLACE(keywords, ',', '')) + 1 from movie where keywords != '' and keywords not null;

		

		keyword sharing movies:

		WITH split(word, str, movie_title) AS (
		select '', keywords||',', title  from movie
		UNION ALL SELECT
		substr(s.str, 0, instr(s.str, ',')),
		substr(s.str, instr(s.str, ',')+1),
		s.movie_title
		FROM split s
		WHERE str!=''
		)
		select word, movie_title from split where word != '' group by word, movie_title;
		
		

		To show how many times the keyword is shared:

		WITH split(word, str, movie_title) AS (
		select '', keywords||',', title  from movie
		UNION ALL SELECT
		substr(s.str, 0, instr(s.str, ',')),
		substr(s.str, instr(s.str, ',')+1),
		s.movie_title
		FROM split s
		WHERE str!=''
		    )
		    SELECT word, count(word) as count FROM split WHERE word!='' 
			group by word having count(word) >= 2;



-Verification 6: Make sure at least two genres are available.

		To make sure each movie has atleast two genre:

		select iif(count(id) > 0, 
		   'True: There are some movies with less than two genre',
		   'false: There are no movies with less than two genre'
		  ) as validation from (
		    select id,title, genre from movie GROUP by id 
		HAVING length(genre) - length(REPLACE(genre, ',', '')) + 1 < 2 or length(genre) is NULL
		  );


		Movies with two or more genre:
	
		select id, genre from movie GROUP by id 
		HAVING length(genre) - length(REPLACE(genre, ',', '')) + 1 >=2;
		


-Verification 7: Not all movies have images.

		select iif(count(*) > 0, 
		   'true: There are some movies without images',
		   'false: There are no movies without images'
		  ) as validation from (
		    select id from movie where image_urls is null or image_urls == ''
		  );

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
    



