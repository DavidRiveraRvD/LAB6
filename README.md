# LAB6

**********************************************************
----------------------------------------------------------
**********************************************************
# LAB6-CVDS

### Datos básicos
 * **Nombres:** David Fernando Rivera\
				Janer Stiven Vanegas
				
				
**********************************************************
----------------------------------------------------------
**********************************************************

## Despliegue, Analisis de codigo e integración continua:


[![Codacy Badge](https://app.codacy.com/project/badge/Grade/baeda125fada42a48af647e4d745e8d4)](https://www.codacy.com/manual/DavidRiveraRvD/LAB6/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=DavidRiveraRvD/LAB6&amp;utm_campaign=Badge_Grade)

[![CircleCI](https://circleci.com/gh/DavidRiveraRvD/LAB6.svg?style=svg)](https://app.circleci.com/pipelines/github/DavidRiveraRvD/LAB6)


**********************************************************
----------------------------------------------------------
**********************************************************

# Parte I. Integración continua
Ingrese al repositorio de WebApp-Heroku-CircleCI-CI en GitHub y resuelva el laboratorio allí especificado usando el proyecto creado en el  Laboratorio 5 - MVC Primefaces Introduction - 2020-2.
1. Creacion de usuarios Heroku.
	* David Rivera
		![alt](resources/HerokuDavid.PNG)
		0eee862c-5c7e-4123-a7c0-7986337d383c
		
**********************************************************

Integración contínua con CircleCI y Heroku
Documentación CircleCI para Heroku:

Para este ejercicio haga uso de la versión funcional de su aplicación: la rama 'master' con la aplicación basada en un 'mock' de la lógica, o la versión completa (en caso de que ya la tenga) ya mezclada en la rama 'master'.

## Parte II.
1. Cree (si no la tiene aún) una cuenta en el proveedor PAAS Heroku (www.heroku.com).

2. Acceda a su cuenta en Heroku y cree una nueva aplicación:

	![alt](resources2/Heroku.PNG)


3. Después de crear su cuenta en Heroku y la respectiva aplicación, genere una llave de API: Opción Manage Account:

4. Ingrese a la plataforma de integración contínua Circle.CI (www.circleci.com). Para ingresar, basta que se autentique con su usuario de GitHUB.
	
	![alt](resources2/Circleci.PNG)

5. Seleccione la opción de agregar proyectos. En la organización o usuario de GitHub, seleccione el proyecto al que le va hacer despliegue continuo, y haga clic en "Build Project":



6. Si todo queda correctamente configurado, cada vez que hagan un PUSH al repositorio, CircleCI ejecutará la fase de construcción del proyecto. Para que cuando las pruebas pasen automáticamente se despliegue en Heroku, debe definir en el archivo circle.yml (ubicado en la raíz del proyecto):
	* La rama del repositorio de GitHUB que se desplegará en Heroku. o El nombre de la aplicación de Heroku en la que se hará el despliegue.
	![alt](resources2/CircleciGit.PNG)
	
	* La ejecución de la fase ‘site’ de Maven, para generar la documentación de pruebas, cubrimiento de pruebas y análisis estático (cuando las mismas sean habilitadas).
	![alt](resources2/Config.PNG)
	
7. Rectifique que en el pom.xml, en la fase de construcción, se tenga el siguiente plugin (es decir, dentro de <build><plugins>):
	![alt](resources2/Plugins.PNG)
	```
	<!-- Plugin configuration for Heroku compatibility. -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <version>2.1</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>copy</goal>
                    </goals>
                    <configuration>
                        <artifactItems>
                            <artifactItem>
                                <groupId>com.github.jsimone</groupId>
                                <artifactId>webapp-runner</artifactId>
                                <version>8.0.30.2</version>
                                <destFileName>webapp-runner.jar</destFileName>
                            </artifactItem>
                        </artifactItems>

                    </configuration>
                </execution>

            </executions>
        </plugin>
	```

8. Heroku requiere los siguientes archivos de configuración (con sus respectivos contenidos) en el directorio raíz del proyecto, de manera que sea qué versión de Java utilizar, y cómo iniciar la aplicación, respectivamente:

	```
	system.properties

	java.runtime.version=1.8
	```
	![alt](resources2/System.PNG)
	
	```
	Procfile

	web:    java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war
	```
	![alt](resources2/Procfile.PNG)
	
	
9. El ambiente de despliegue contínuo requiere también un archivo de configuración 'circle.yml' en la raíz del proyecto, en el cual se indica (entre otras cosas) en qué aplicación de Heroku se debe desplegar la aplicación que está en GitHUB. Puede basarse en el siguiente archivo, teniendo en cuenta que se debe ajustar el parámetro 'appname': https://github.com/PDSW-ECI/base-proyectos/blob/master/circle.yml

10. Haga commit y push de su repositorio local a GitHub. Abra la consola de CircleCI y verifique que el de descarga, compilación, y despliegue. Igualmente, verifique que la aplicación haya sido desplegada en Heroku.
	![alt](resources2/Pipelines.PNG)
	
11. Ahora, va a integrar un entorno de Análisis de Calidad de Código a su proyecto, el cual detecte contínuamente defectos asociados al mismo. Autentíquese en CODACY con su cuenta de GitHUB, y agregue el proyecto antes creado.

	![alt](resources2/Codaci.PNG)
	![alt](resources2/Codacii.PNG)

12. Cree un archivo README.md para su proyecto, y asocie al mismo dos 'badges', que permitan conocer el estado del proyecto en cualquier momento: uno para Circle.CI, y otro para CODACY. El proyecto usado como referencia, ya incluye dichos 'badges' en su archivo README: https://github.com/PDSW-ECI/base-proyectos	
	## Despliegue, Analisis de codigo e integración continua:
	[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://calculator-lab06.herokuapp.com/faces/calculadora.xhtml)

	[![Codacy Badge](https://app.codacy.com/project/badge/Grade/fac41f46bfa3417ea44604b512896585)](https://www.codacy.com/manual/Candres1019/LAB6_CVDS?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Candres1019/LAB6_CVDS&amp;utm_campaign=Badge_Grade)

	[![CircleCI](https://circleci.com/gh/Candres1019/LAB6_CVDS.svg?style=svg)](https://app.circleci.com/pipelines/github/Candres1019/LAB6_CVDS)


**********************************************************

## Parte II. Interfaz Gráfica
Agregue mayor detalle a la interfaz gráfica de la página web para que se vea más amigable al usuario. Busque y agregue estilos, colores de fondo, títulos, centrar la página, etc. cualquier elemento o detalle que pueda mejorar cómo se ve la página y como el usuario la percibe.

Si no recuerda cómo hacerlo, puede revisar la información disponible en W3Schools para HTML y CSS.
	![alt](resources2/App.jpg)

