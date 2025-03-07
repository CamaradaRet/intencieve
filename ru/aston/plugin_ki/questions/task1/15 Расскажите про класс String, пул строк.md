Расскажите про класс String, пул строк

Класс String представляет символьные строки. Все строковые литералы в Java-программах, такие как "abc", реализованы как экземпляры этого класса. 
Строки являются константами; их значения нельзя изменить после их создания. Любые операции над объектом String, результатом которых должен быть объект класса String, приведут к созданию нового объекта.
Класс String включает в себя методы для проверки отдельных символов последовательности, для сравнения строк, для поиска строк, для извлечения подстрок и для создания копии строки со всеми символами, переведенными в верхний или нижний регистр.
Язык Java предоставляет специальную поддержку для оператора объединения строк( + ) и для преобразования других объектов в строки. Каждый объект в Java может быть преобразован в строку через метод toString, унаследованный всеми Java-классами от класса Object. Реализация оператора конкатенации строк( + ) оставлена на усмотрение компилятора Java, при условии, что компилятор в конечном счете соответствует спецификации языка Java.
Благодаря тому что класс String immutable, объекты класса String являются потокобезопасными и могут быть использованы в многопоточной среде.
Класс String в Java — это final класс, который не может иметь потомков.

Использование switch для строк в Java:

•	использование строк в конструкции switch делает код читабельнее, убирая множественные цепи условий if-else.

•	строки в switch чувствительны к регистру, пример выше показывает это.

•	оператор switch использует метод String.equals() для сравнения полученного значения со значениями case, поэтому добавьте проверку на NULL во избежание NullPointerException.

•	согласно документации Java 7 для строк в switch, компилятор Java формирует более эффективный байткод для строк в конструкции switch, чем для сцепленных условий if-else.

•	Switch может использоваться начиная с Java 7 или поздней версии, иначе будет выброшено исключение исключение.


String могут задаваться литералами: 

    String literalString = "Hello, World!"; 

То есть любая строка в кавычках, как указано выше, на самом деле объект.
String Pool – это место, где хранятся строки. Расположен  в Heap памяти, в особой runtime constant pool области. Runtime constant pool выделяется при создании класса или интерфейса виртуальной машиной из method area - особой области в Heap, доступ к которой есть у всех потоков внутри виртуальной машины Java. При создании строки JVM проверяет есть ли уже такая строка в пуле и если есть то просто присваивает переменной ссылку на эту строку, а новой такой же строки не создаётся. 
В пуле хранятся строки которые объявлены как литералы т.е. “строка - литерал”, поэтому при сравнении двух одинаковых строк созданных по-разному (т.е. одна создана присвоением литерала String str = “string”, а вторая через оператор new – String srt1 = new String(“string”) ) с помощью оператора сравнения  == , результат будет false. Оператор сравнения  == сравнивает содержимое переменных которое в ссылочных переменных является ссылкой на объект, но не сам объект, и потому сравнивая переменные str и str1 мы пытаемся узнать хранят ли две разных переменных ссылку на один и тот же объект. При сравнении этих переменных методом equals() который переопределен в String мы получим положительный результат ибо метод сравнивает непосредственно объекты, а не ссылки.  Так же если сравнить две переменных созданных через объявление литерала то результат будет true. Т.е.

    String str1 = “string”; String str2 = “string”; Systerm.out.print(str1==str2); 

вывод будет true.

Ресурсы:

https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html 

https://docs.oracle.com/javase/specs/jvms/se21/html/index.html 
