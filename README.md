# find-me-a-spot-Bonn
Bootstrap Website to make use of Bonn Data-set of Parking locations and spaces available in the city

## Tools
Bonn Dataset && API https://opendata.bonn.de/dataset  
Dataset packages & resources https://opendata.bonn.de/api/3/action/package_show?id=54ca0aef-96a9-4996-b9c8-e9a75414267b  
Dataset Metadata https://opendata.bonn.de/api/3/action/resource_show?id=7b40f445-29ac-45e0-b4c7-2b457998bd1c  

## Installation
GWT 2.8  
Java 8  
Eclipse IDE  
Gradle Wrapper included in project  

## Usage
Current Java code in BonnService can be tested with BonnServiceTest class to return Parkhaus Info  
Further implementation in GWT to include a front end halted, as API not available from Bonn Stadt  
Provider of Information is City Parkraum GmbH (http://ogdcockpit.bonn.de/index.php/Parkpl%C3%A4tze#tab=Datenmonitoring) and not Bonn Stadt - no API available or planned (http://ogdcockpit.bonn.de/index.php/Datensatzw%C3%BCnsche)  

## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request

## History
12.04.17 GWT WebApp Version  
09.04.17 Console Version  
06.04.17 Project Creation  

## Roadmap
TODO:
Bonn Service for Bonn Parking Information  
Köln Service for Parking Information(not yet available)  
Web App sort list based on spaces available  
Web App sort list based on proximity  
Show available parking on map  
Android Version  
iPhone Version  

## Credits
Datasource: [Parkhäuser der BCP Bonn GmbH](https://opendata.bonn.de/dataset/7b40f445-29ac-45e0-b4c7-2b457998bd1c/resource/7b40f445-29ac-45e0-b4c7-2b457998bd1c)

## License
TODO: Write license  
