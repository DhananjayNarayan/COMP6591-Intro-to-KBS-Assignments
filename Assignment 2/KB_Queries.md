## Prolog Queries to Demonstrate Use of KB

-Open the prolog editor and to compile type 

    consult('moviekb.pl'). 

-Query: Adding Movies

    add_movie('tt3175038','Ek Villain',thriller,2014,6.5,[murder,villain,jealous],[telugu,tamil]).
    add_movie('tt11947158','Ek Villain 2',thriller,2022,7.5,[murder,villain,jealous],[tamil,telugu]).
    movie(_,'Ek Villain',_,_,_,_,_). #This confirms the existence of the movie in the KB. 

-Query: Queries to Add Actors
    
    add_actor('nm1303433','John Abraham',male,46).
    add_actor('nm7796669','Disha Patani',female,32).
    add_actor('nm1819083','Arjun Kapoor',male,41).
    add_actor('nm3289096','Siddarth Malhotra',male,32).
    add_actor('nm1299011','Ritesh Deshmukh',male,44).
    actor(_,'Ritesh Deshmukh',_,_). #This confirms the existence of the new actor added
    
      
 -Query: Queries to Update Movie Details
    
    update_movie_title('tt11947158','Ek Villain Returns').
    update_movie_genre('tt11947158',romance).
    update_movie_year('tt11947158',2021).
    update_movie_rating('tt11947158',8.2).
    update_movie_keywords('tt11947158',[love,murder,villain,envy,compassion]).
    update_movie_languages('tt11947158',[tamil]).
    movie('tt11947158',A,B,C,D,E,F).   #We can see the updated details
 
 -Query: Queries to update Actor Details
    
    update_actor_name('nm1303433','Jenny Abraham').
    update_actor_age('nm1303433',56).
    update_actor_gender('nm1303433',female).
    actor('nm1303433',X,Y,Z).  #We can see the updated details of the actor
   
 -Query: Queries to Map movies to actors
    
    add_movie_actor('tt11947158','nm1303433').
    add_movie_actor('tt11947158','nm7796669').
    add_movie_actor('tt11947158','nm1819083').
    add_movie_actor('tt3175038','nm3289096').
    add_movie_actor('tt3175038','nm1299011').
    add_movie_actor('tt3175038','nm3601766').
   
 -Query: Query to Delete Information
 
    delete_movie('tt3175038').
    delete_movie('tt11947158'). #Shows False confirming the movie is delted
    movie('tt11947158',_,_,_,_,_,_).
    
    delete_actor('nm1303433').
    actor('nm1303433',_,_,_).  #Shows False confirming the actor is delted
 
 
# Prolog Queries to demonstrate Violating the Conditions 
   
 -Query: Adding a movie with incorrect genre.
    
    add_movie('tt111','The Grey Man',adventure,2022,8.2,[spy,assassin,info,murder,cheating],[english]).
    #This returns false and does not succeed as a genre called adventure is not defined.
 
 -Query: Adding a movie with incorrect language.
    
    add_movie('tt222','Kurup',romance,2022,7.2,[spy,assassin,info,murder,cheating],[english,malayalam]).
    #This returns false and does not succeed as a language called malayalam is not defined. 
    
 -Query: Adding a movie with less than 5 keywords
 
    add_movie('tt225','Kurup 2',romance,2022,7.2,[assassin,info,murder,cheating],[english,tamil]).
    #This returns false and does not succeed as the number of keywords is less than 5. 
    
 -Query: Trying to add a duplicate movie
 
    add_movie('tt7144666','The Black Phone',thriller,2021,7.3,[phone,murder,call,kidnapper,kids,ghost,survival,kidnap],[english]).
    #This returns false as addition of duplicate movie is not allowed
    
 -Query: Trying to delete a non-existing movie
 
    delete_movie('dj123').
    #This returns false as a movie with ID 'dj123' does not exist in the KB
   
    
 # Prolog Queries for Categorical Syllogisms
    



