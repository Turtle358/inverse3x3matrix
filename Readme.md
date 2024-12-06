# 3x3 Matrix Inversing tool

## How do you run this?
You can either open the source code in your editor of choice, or you can use .jar file from the Releases tab by either double clicking or running the terminal command
```shell
  java -jar ./matricies.jar
```
## How do we inverse a matrix?
DMCTD

D - dirty

M - miners

C - cough

T - (on public) transport 

D - (and) Die

Morbid but works ^

1. Calculate the determinate (D)
2. Calculate the matrix of Minors (M)
3. Apply the cofactor matrix (C):

![cofactorMatrix.png](./readmeImages/cofactorMatrix.png)

4. Transpose the matrix (along the leading diagonal) (T)
5. Multiply every item in the matrix by 1/determinate (D)
