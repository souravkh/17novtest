// Program for area of circle
# include<stdio.h>

int main(){
    float radius;
    printf("write radius of circle ");
    scanf("%f",&radius);
    printf(" the area of circle: %f", 3.14*radius*radius);
    /* there is no new variable to store area taken
    direct formula in printf can be a new way */
    return 0;
}