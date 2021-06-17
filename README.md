# Skeleton Kafka app Sommerstudenter 2021

## Oppgave

Enhver sommerstudent skal;
1. Forke dette repoet til et nytt et innenfor NAVIKT
2. Legge inn sitt Github brukernavn i [nais/nais.yaml](nais/nais.yaml) [her](nais/nais.yaml#L4) og [her](nais/nais.yaml#L30)
3. Skrive Kotlin kode i fil [ProduceRoute.kt](src/main/kotlin/no/nav/ProduceRoute.kt#L17)
4. Legge inn [`NAIS_DEPLOY_KEY`](nais/nais.yaml#L30)en tilhørende namespacet `sommerstudenter2021` som hemmelighet i sitt forkede repo (finnes her: [NAIS deploys](https://deploy.nais.io))
5. Utnytte [Github Workflow Pipeline](.github/workflows/main.yaml) til å deploye applikasjonen
6. Sende HTTP GET Requests til `https://<github brukernavn>.dev.intern.nav.no`
7. Kunne se [på dette Grafana dashboardet](https://grafana.nais.io/d/Ke8RDTgnz/sommerstudent-daemon2021?orgId=1) at meldingen ble mottatt av Kafka topicen! =)

## Formål
Dette repoet inneholder en demo app som har som formål å la sommerstudentene;
- bygge et eget docker image
- deploye dette med NAIS
- og få denne eksponert på en `https://<sitt github brukernavn>.dev.intern.nav.no` adresse

Når;
1. appen mottar en HTTP GET request til `/produce/<en html parset melding>`, skal det 
2. dukke opp på [grafana URL] at "app `X` har sendt melding til kafka-topic `sommer-kafka`!"

## Pre-requisites

Enhver sommerstudent må ha;
1. En NAV laptop
2. [naisdevice](https://doc.nais.io/device/) installert og satt opp
3. [gcloud](https://cloud.google.com/sdk/docs/install) installert og logget inn med Google NAV-epost konto
4. [kubectl](https://kubernetes.io/docs/tasks/tools/) installert ihht. versjonen på `dev-gcp` clusteret
    - "At time of commit" er dette `v1.18.*`, det går bra med versjonsdiff på opptil 1-2 feature versjoner
5. `git` installert og tilgjengelig i terminal, samt author og ssh nøkler satt hhv. lokalt og hos github
6. Lagt seg til i `navikt` Github orgen på [NAV myapps](https://myapplications.microsoft.com/)
7. `java` jdk installert (les: `JAVA_HOME` må fungere i samarbeid med [gradlew(.bat)](gradlew)
8. Zoom installert
9. Være lagt til `sommerstudenter2021` gruppen tilgjengelig på [mygroups.microsoft.com](https://mygroups.microsoft.com) når logget inn med sin NAV AD bruker

---
Skrevet av:
- [@albrektsson](https://github.com/albrektsson)
- [@thokra-nav](https://github.com/thokra-nav)
- [@x10an14](https://github.com/x10an14)

