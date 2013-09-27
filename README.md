Hive-DAQ
========

An Android app for data collection with sticky fingers.

First phase:  Minimum needed for my functionality.

- Nested menus that group options.  These options can be selected and added to a database to form 
  a description of the current status of a hive. 
		- Design for sticky/dirty/touch compatible gloves... meaning no sliding, just pressing buttons.  
		- I expect up to 12 menus, with 12 sub menus, with 12 options?
		- Buttons change color to indicate which menus have options already selected.

- A Dedicated voice recorder button. To insert vocal notes that don't fit the standardized options of the menus.
	Audio clips would be tagged with a subject based on what menu you are in when you clicked record.
    (ex. if I record audio of hive H213 on July 5th while in a sub menu about disease: H213-2013.07.05-disease.3gp)

- The database. Don't know much about this aspect of it.  Eryn says I can do better than Excel.  Options to back up 
  constantly over mobile network, or just when connected to wifi.



Second phase:  Bells and whistles that will make it much nicer to use.

- Use NFC tags to identify hives. Audio from previous inspection could auto-play when scanned.

- Add a dedicated camera button that takes a photo and names it based on date, hive, and current menu.
    (ex. if I take a picture of hive H213 on July 5th while in a sub menu about disease: H213-2013.07.05-disease.jpg)



Third phase:  Extra bells and whistles, and make it useable for other people and uses.

- An editor to customize the menus.  Ideally this will not be used in the field and can use advanced touch screen   
  options.  Editing menus will probably wreak havoc on data already in the database.

- Audio to text.  Using Google voice API, attempt to translate recorded notes to text and enter in database.

- Add .CSV file dump for Excel compatability.
