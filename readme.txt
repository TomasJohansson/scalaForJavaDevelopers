The code in this project ("scalaForJavaDevelopers") has been tested with (Windows 7) installations of Java 6 , Scala 2.10.1 and SBT 0.12.3.

If you want to execute the code and have not yet installed Java, Scala and SBT, here are some links:
http://www.java.com
http://www.scala-lang.org
http://www.scala-sbt.org


The code examples in this project was written by me in the beginning of 2010, and its purpose is not to be useful for anything else but for pedagogical reasons.
I wrote the code samples in the project when I just had learned some Scala programming and since I liked the language I wanted 
to do a small contribution of trying to help with popularizing the Scala language among Java programmers.
Therefore, my focus in all code examples was to illustrate advantages of using Scala instead of Java.

At that time (2010) the code examples was not uploaded anywhere as a complete project 
but the code was only published within HTML pages, and can currently (april 2013) be located from this URL:
http://www.oo-systemutvecklare.se/scala-for-java-utvecklare/

The above starting page is targeted for Swedish people, but for those of you who only understand english and 
want to read the comments for the code examples, here is a starting point for finding the code examples:
http://www.oo-systemutvecklare.se/scala-for-java-developers/

Now (in april 2013) more than three years later, I have put together the code into a SBT project and uploaded it to github:
https://github.com/TomasJohansson/

The code is essentially the same as in the original web pages, but with a few modifications.
For example, in one of the classes, I previously used a third-part library found at 'https://github.com/jorgeortiz85/scala-javautils'.
I then used it for converting a java list to a Scala list, with a method 'asJava' 
but now with a later Scala version I use 'scala.collection.JavaConverters' instead of the third-part library.

I can also mention that I have not (at least not yet/currently) updated the web pages with 
the small modifications I made to the code in this github project where you found the code examples.

Please keep in mind the mentioned purpose of the examples when you read the code, i.e. illustrate potential advantages of Scala over Java.
In other words, the code examples is not optimized for other generally desired aspects of programming such as minimization of code duplication 
(however, for some of the code examples, it was actually the purpose to illustrate that Scala code can be much less verbose than Java code).
Also, some of the "test" classes is spitting out output (with System.out.println) which is generally not at all desired, 
and some of the test classes are more used like starting points of execution (i.e. like a main method) than 
having lots of assertion tests, which is what you typically want in real projects.
The SBT command "test" will execute all the tests, but since some of them will output print statement 
you can choose to execute individual "tests" with the command documented at the top of the test classes, 
for example the following SBT command can be used for one of the tests:
test-only observerTrait.VerifyObservableNotificationsWithJavaAndScala

/ Tomas Johansson 2013-04-26
