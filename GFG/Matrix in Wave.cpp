#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
{
     int rows,columns;
    cout<<"Enter number of rows: ";
    cin>>rows;
    cout<<"Enter number of columns: ";
    cin>>columns;
    int a[rows][columns];
    cout<<"Enter the matrix "<<endl;
    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < columns; j++)
        {
            cin>>a[i][j];
        }
    }
    // Now comes the important logic
    for(int j = 0; j < columns; j++)
    {
        if(j % 2 == 0)
        {
            for(int i = 0; i < rows; i++)
            {
                cout<<a[i][j]<<" ";
            }
        }
        else
        {
            for(int i = rows - 1; i>= 0; i--)
            {
                cout<<a[i][j]<<" ";
            }
        }
        
    }
    return 0;
}