# OOP2 Programmierprojekt FS19

## Bearbeitet von
 - Remo von Arx

## Abgabe
- Mittwoch, 5.6.2019, 18:00 Uhr
- Die Abgabe erfolgt durch ein "Push" auf den Master-Branch in Ihrem GitHub-Repository.

## Aufgabe: ChargingStationsFX

Implementieren Sie eine Applikation auf Basis JavaFX gemäss der Aufgabenbeschreibung auf dem AD. 

Die dort vorhandene Beschreibung ist massgebend, hier die wichtigsten Punkte:
 - Benutzen Sie zur Umsetzung die vorgegebene Struktur des "Application-Template".
 - Die Verwendung von SceneBuilder und FXML ist nicht erlaubt.
 - Für eine 4.0 müssen folgende Basis-Features implementiert sein
   
## Basis-Features  
   
   - [x] Einlesen der Daten
   - [x] Abspeichern der Änderungen
   - [x] Darstellen aller Ladestationen in Tabelle/Liste 
   
   - [x] Editor-Bereich
     - [x] Editor-Bereich arbeitet stets auf der in der Tabelle selektierten Ladestation
     - [x] Änderungen führen zu *unmittelbarem* Update der Tabelle und des Headers
     - [x] Ein- Ausblenden der "Steckertypen" und "Leistung" abhängig von Anzahl Ladepunkte
     - [x] unmittelbare Berechnung der Gesamt-Anschlussleistung
   
   - [x] Header-Bereich 
     - [x] Darstellung von: Typ, Strasse, Postleitzahl, Ort, Anzahl Ladepunkte, Anschlussleistung
   
   - [x] einfaches Styling via CSS
   - [x] Layout mit SplitPane
   - [x] sinnvolles Resizing-Verhalten
   - [x] Anlegen einer neuen Ladestation
   - [x] Löschen bestehender Ladestationen
   - [x] Programmstruktur
      - [x] zwei Layer für Presentation-Model und View 
  
## Zusatz-Features (geplant)

   -  Änderungen in Tabelle führen zu Update im Editor-Bereich
   -  einfaches Styling der gesamten Applikation via CSS
   - [x] Enabling/Disabling
        - [x] der Buttons
        - [x] des Editors falls keine Ladestation selektiert ist
   - [x] Freitextsuche
   - Aussagekräftige JUnit-Tests 
