## scope
test, provided, compiled (default) i inne
## struktura katalogow w dokumentacji
sa tez takie katalogi jak /it, /site i inne
standard - src/main/resource; src/test
## Lifecycles
lifecycle - jakis proces budowania. sklada sie z predefined faz
kazda faza sklada sie z jednego lub wielu goals pluginu

cala robota mvn robiona jest przez pluginy

lifecycle i fazy pozwalaja wolac cele pluginow (goal) w sekwencji

<b>CLI:

mvn LIFECYCLE1 LIFECYCLE2
mvn PLUGIN:GOAL</b>

3 predefined lifecycle:
* clean - czysci. ma defaultowe pluginy
* default - budowanie, test, package, deploy. Nie ma defaultowych pluginow
* site - tworzy strone projektu, ma pluginy, rzadko uzywane

kazda szczegolowa faza w ramach lifecycle puszcza poprzednie w ramach tego samego lifecycle.
install pusci compile, package, test itd.

#### clean
3 fazy
* pre-clean
* clean - mvn clean plugin, goal: clean
* post-clean


#### default - high level
- validate - sprawdza czy projekt jest ok
- compile
- test
- package
- verify - testy integracyjne
- install - install w local mvn repo
- deploy - deploy do shared mvn repo

https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Lifecycle_Reference
faz jest sporo wiecej w default, initialize, generate sources, process classes,
 pre-interation-test etc.
mozna sie zapiac na kazda z tych faz

### site - 4 fazy
 - pre-site
 - site - plugin: maven-site-plugin:site
 - post-site
 - site-deploy - plugin: maven-site-plugin:deploy
 
 ## mvn wrapper
 mozna deployowac mvn razem z projektem. build jest portable
 plugin io.takari:mvn:wrapper
 to utworzy folder .mvnw 
  
  ## archetypy
  typowe projekty, szablony. Spring Initializr lepszy ;]

------------------------------  
# Standardowe pluginy
  * clean - wewnatrz lifecycle clean
  * compiler - default lifecycle. kompiluje testy lub kod
  * resources - default lifeccyle. przenosi pliki do dir output
  * surefire - default lifecycle. odpala testy jednostkowe. junit, testng (+cucumber i spock)
  * jar - default lifecycle. robi jar z aplikacja lub z testami
  * deploy - default. Wrzuca artefakty do mvn repo
  * site - site lifecycle. Robi strone mavenowa projektu. Ma 7 celow
  
  na stronie apache mvn jest lista pluginow
  
 ## hooki w pom:
 mozna zapiac sie na konkretna faze z ktoregos lifecycle
 i wykonac jakis plugin. np w pom:
 
 build, plugins, plugin 
 artifact - jaki plugin chce zawolac
  executions execute
    id - moja nazwa hooka
    phase - podczas ktorej fazy ma sie ten hook wywolac
    goals
     goal - co - czyli jaki plugin goal ma sie zawolac podczas hooka
   
   
  ### resource plugin
  orpocz hookow mozna includowac albo excludowac rozne pliki, generowac dodatkow, zmieniac katalog /resource itd. 
  
  ### surefire plugin
  wszystko co konczy/zaczyna sie na Test/tests/testCase zostanie zebrane przez plugin!!!
  Jak nie ma to plugin nie zlapie (intellij juz tak)
  
  w outpucie sa raporty z surefire w .txt i xml
  
  ### jar plugin
  popularna rzecz to executable jar. mozna skonfigurowac wg https://maven.apache.org/shared/maven-archiver/examples/classpath.html
  
  ### deploy plugin
  upload do mvn repo. W pom trzeba wyspecyfikowac deployManagement
  
  ### mvn dependency:tree
  tworzy drzewo dependencji
  