# Floyd's Triangle

This is an implementation of Floyd's Triangle. It shows how to write an application using a top-down approach. The methods at the top of FloydsTriangle.java were written first and the methods at the bottom were written last. The top methods are more general and the bottom methods are more specific.

The Floyd's Triangle looks like this:
```
  1                                                             1
  2   3                                                         2
  4   5   6                                                     3
  7   8   9  10                                                 4
 11  12  13  14  15                                             5
 16  17  18  19  20  21                                         6
 22  23  24  25  26  27  28                                     7
 29  30  31  32  33  34  35  36                                 8
 37  38  39  40  41  42  43  44  45                             9
 46  47  48  49  50  51  52  53  54  55                        10
 56  57  58  59  60  61  62  63  64  65  66                    11
 67  68  69  70  71  72  73  74  75  76  77  78                12
 79  80  81  82  83  84  85  86  87  88  89  90  91            13
 92  93  94  95  96  97  98  99 100 101 102 103 104 105        14
106 107 108 109 110 111 112 113 114 115 116 117 118 119 120    15
```
Here are the rules:
1. The first row is row number 1.
1. Each row has the same number of elements as the row number.
1. The first element (in the first row) is 1.
1. Each element is numbered successively over the entire triangle.
1. The last element on any row is calculated by: row * (row + 1) / 2
1. Each cell is the width of the largest number plus 1.
1. The numbers in each cell are right-justified
