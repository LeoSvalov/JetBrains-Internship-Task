# JetBrains-Internship-Task
Simple spellchecker that is based on the Damerau–Levenshtein distance algorithm.

Spellchecker основан на [алгортме Дамерау-Левенштайна](https://ru.wikipedia.org/wiki/Расстояние_Дамерау_—_Левенштейна),
который рассчитывает схожесть двух слов.

**Словарь** - [words.txt](https://github.com/LeoSvalov/JetBrains-Internship-Task/blob/master/words.txt), содержащий около 370 тыс. английских
слов нижнего регистра. Источник словаря - [здесь](https://github.com/dwyl/english-words).

**Spellchecker** - суть [решения](https://github.com/LeoSvalov/JetBrains-Internship-Task/blob/master/Main.java) в том, что считали весь словарь в хэш-сет, если слова нет в словаре, то ищем слова с наименьшим расстоянием Дамерау-Левенштайна.
