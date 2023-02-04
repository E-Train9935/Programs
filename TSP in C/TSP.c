// Gets cities and the optimal value as a user input. If cities is less than that optimal value (b), print yes orhter print no
#include <stdio.h>
int main() {
    printf("Enter the number of cities: ");
    int n;
    scanf("%d", &n);
    int cities[n][n];
    printf("Enter the optimal value to beat: ");
    int b;
    scanf("%d", &b);
    for (int i = 0; i < n; i++) {
        printf("Enter the cities' distances:            (EX: [-1, 5, 10, 15] is one city's distances and -1 is for city it is already in)");
        for (int j = 0; j < n; j++)
            scanf("%d", &cities[i][j]);
    }
    if (b > greedyTSP(cities))
        printf("YES");
    else
        printf("NO");
    return 0;
}

// Took the greedy aproach by looking at the minimum distance of each iteration and saving the one that is the minimum distance across all iterations
// Then saving the route of the minimum distance 
// lastly calculating the sum of all the optimal route and then adding its distance values and returning the sum of the distances
int greedyTSP(int tsp [][]) {
    int result = 0;
    int counter = 0;
    int i = 0;
    int j = 0;
    int min = 999999999;
    int tspArraySize = sizeof(tsp) / sizeof(tsp[0]);
    int visitedCities[tspArraySize];
    visitedCities[0] = 1;
    int optimalRoute[tspArraySize];
    for (int k = 0; k < tspArraySize; k++)
        optimalRoute[k] = 0;

    while (i < tspArraySize && j < sizeof(tsp[i])) {
        if (counter >= sizeof(tsp[i]) - 1)
            break;
        if (j != i && isInRoute(visitedCities, j, tspArraySize)) {
            if (tsp[i][j] < min) {
                min = tsp[i][j];
                optimalRoute[counter] = j + 1;
            }
        }
        j++;
        if (j == sizeof(tsp[i]) / sizeof(tsp[0])) {
            result += min;
            min = 999999999; 
            visitedCities[optimalRoute[counter] - 1] = 1;
            j = 0;
            i = optimalRoute[counter] - 1;
            counter++;
        }
    }
    i = optimalRoute[counter - 1] - 1; 
    for (j = 0; j < tspArraySize; j++) {
        if (i != j && tsp[i][j] < min) {
            min = tsp[i][j];
            optimalRoute[counter] = j++; 
        }
    }
    result += min;
    return result;
}

// small function to check if a distance has already been checked
bool isInRoute(int array[], int value, int arraySize) {
    for(i = 0; i < arraySize; i++) {
        if(array[i] == value)
            return 1;
    }
    return 0;
}
