# throun8f
Ætti að vera nóg að clone-a verkefnið og keyra allir lib eru inní git-repo.

Controllerinn hér fyrir neðan ætti að vera nóg fyrir ykkur til þess að fá og gera eitthvað við databaseinn.


FlightController:

Lýsing: Heldur utan um einu aðferðirnar sem þarf, það er book og search

Aðferðir: 

search(String departure, String destination, String date) leitar af flugum sem fara frá departure flugvelli og til destination flugvallar á ákveðinni         dagsetningu date. Skilar lista af ObservableList <FlightDetails> af flugum sem passa við viðföngin.
  
book(Seat seat, FlightDetails flightDetails, Passenger passenger) bókar ákveðið Seat miðað við flug FlightDetails og bætir Passanger inná passanger databaseinn.

Eina sem ég bendi á er að skoða klasana ef notað er book þ.e.a.s Seat , FlightDetails og Passenger.
