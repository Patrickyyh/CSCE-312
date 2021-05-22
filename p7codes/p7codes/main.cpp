//
//  main.cpp
//  P7
//
//  Name: Yuhao Ye
//  UIN:  529006730

#include "MatrixMultiplication.h"
using namespace std;
#include<iostream>
#include<fstream>
#include<string>
#include<sstream>
#include<vector>
#include <chrono>

using namespace std::chrono;



void display(const vector<vector<int>>target){
   int i , j;
   for(i = 0 ; i < target.size() ; ++i){
      for(j = 0 ; j < target.size(); ++j){
          cout << target[i][j] << " ";
      }
      cout << endl;
   }
}


int main(int argc, const char * argv[]) {

    // File Read Operation
    ifstream infile;
    int size_N = 0;
    vector<vector<int>>a;
    vector<vector<int>>b;
    //cout <<　argv[1] << endl;
    infile.open(argv[1],ios_base::in);


    if(infile.fail()){
       cout<<"The File was not successfully open !" << endl;
       exit(1);
    }

    string line;
    int count= 0;
    getline(infile,line);
    string test;
    istringstream iss1(line);
    iss1 >> size_N;
    cout << size_N << endl;

    while(getline(infile,line)){
      if(!line.empty()){
            istringstream iss(line);
            if(count < size_N){
            vector<int>temp;
            for(unsigned int i = 0 ; i < size_N  ; ++i){
                 int value;
                 iss>>value;
                 temp.push_back(value);
             }
            a.push_back(temp);

          }else{
            vector<int>temp;
            for(unsigned int i = 0 ; i < size_N  ; ++i){
                 int value;
                 iss>>value;
                 temp.push_back(value);
             }
            b.push_back(temp);
          }
            ++count;
    }

  }


  // Matrix Mult 1 (ijk) mix of column and row
  vector<vector<int>> result1(size_N,vector<int>(size_N,0));
  clock_t start;
  double duration;
  start = clock();
  matrixMult1(a,b,result1,size_N);
  duration = (clock() - start) / (double) CLOCKS_PER_SEC;
  cout << "Duration (mix of column and ros): " << duration << endl;
  //display(result1);


  // Matrix Mult 2  // row major
  vector<vector<int>> result2(size_N,vector<int>(size_N,0));
  clock_t start1 = clock();
  double duration1;
  matrixMult2(a,b,result2,size_N);
  duration1 = (clock() - start1) / (double) CLOCKS_PER_SEC;
  cout << "Duration (rows major ): " << duration1 << endl;

    // Matrix Mult 3 // column major
 vector<vector<int>> result3(size_N,vector<int>(size_N,0));
 clock_t start2 = clock();
 double duration2;
 matrixMult3(a,b,result3,size_N);
 duration2 = (clock() - start2) / (double) CLOCKS_PER_SEC;

 cout << "Duration (column major ): " << duration2 << endl;

    // Matrix Mult Blocking

  vector<vector<int>> result4(size_N,vector<int>(size_N,0));
  clock_t start3 = clock();
  blockingMatrixMult(a,b,result4,size_N,50);
  double duration3;
  duration3 = (clock() - start3) / (double) CLOCKS_PER_SEC;
  cout << "Duration (blocking ): " << duration3 << endl;

    // Extra Credit (OPTIONAL)


    return 0;
}
