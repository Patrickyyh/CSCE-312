//
//  MatrixMultiplication.cpp
//  P7
//
//  Name: Yuhao Ye
//  UIN: 529006730

#include "MatrixMultiplication.h"
using namespace std;
#include<vector>

void matrixMult1(const std::vector<std::vector<int>>& a, const std::vector<std::vector<int>>& b, std::vector<std::vector<int>>& result, const int n) {
      int i ,j , k;
      int sum;
      for(j = 0 ; j < n ; j++){
        for( i = 0 ; i < n ; i++){
           sum = 0 ;
           for ( k = 0 ; k < n ; k++) {
              sum += (a[i][k]) * (b[k][j]);
           }
           result[i][j] = sum;
        }
      }

}



void matrixMult2(const std::vector<std::vector<int>>& a, const std::vector<std::vector<int>>& b, std::vector<std::vector<int>>& result, const int n) {
      int i ,j ,k;
      int value;
      for(i = 0 ; i < n ; i++){
        for(k = 0 ; k < n ; k++){
           value = a[i][k];
           for(j = 0 ; j < n ; j++){
              result[i][j] +=  value * (b[k][j]);
           }
        }
      }
}


void matrixMult3(const std::vector<std::vector<int>>& a, const std::vector<std::vector<int>>& b, std::vector<std::vector<int>>& result, const int n){
      int i ,j ,k ;
      int value ;
      for(j = 0  ; j < n ; ++j){
        for(k = 0 ; k < n ; k++){
           value = b[k][j];
           for(i = 0 ; i < n ; ++i){
              result[i][j] += a[i][k] * value;
           }
        }
      }

}


void blockingMatrixMult(const std::vector<std::vector<int>>& a, const std::vector<std::vector<int>>& b, std::vector<std::vector<int>>& result, const int n, const int block_size) {

    int kk , jj , i,j,k;
    int value;
    int N = block_size * (n/block_size);

    for(kk = 0 ; kk < N; kk +=  block_size){
      for(jj = 0 ; jj < N ; jj += block_size ){
         for(i = 0 ; i < N ;++i){
             for(j = jj ; j < jj + block_size ; ++j){
                value = result[i][j];
                for(k = kk ; k < kk + block_size ; ++k){
                   value += a[i][k] * b[k][j];
                }
                result[i][j] = value;
             }

         }

      }

    }




}

// Extra Credit (OPTIONAL)
//void matrixTranspose(const std::vector<std::vector<int>>& a, std::vector<std::vector<int>>& result, const int n) {
//
//}
//
//void blockingMatrixTranspose(const std::vector<std::vector<int>>& a, std::vector<std::vector<int>>& result, const int n, const int block_size) {
//
//}
