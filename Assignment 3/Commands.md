# Commands

### -Loading the Database

    pl C:/Users/madhu/MACS_Courses/Summer22/kbs/kbs-assignments/datalogkbs/src/database_facts/parent.pl 
   
    pl C:/Users/madhu/MACS_Courses/Summer22/kbs/kbs-assignments/datalogkbs/src/database_facts/instructor_facts.dl

 ### -Loading the Datalog Rules

    dl C:\Users\madhu\MACS_Courses\Summer22\kbs\kbs-assignments\datalogkbs\src\datalog_programs\parent.txt
    dl C:\Users\madhu\MACS_Courses\Summer22\kbs\kbs-assignments\datalogkbs\src\datalog_programs\instructor_rules.dl
  
 ### -Queries
 
    query ancestor('John','Peter')
    query parent('John','Walter')

