// https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/

public int largestRectangleArea(int[] heights) {
    Stack<Integer> result = new Stack<Integer>();
    int top_val; // Top of stack
    int max_area = 0; // Initialize max area in current
    // heights (or histogram)
    int area = 0; // Initialize area with current top
    // Run through all bars of given histogram (or heights)
    int i = 0;
    int C = heights.length;
    while (i < C) {
        // If this bar is higher than the bar on top
        // stack, push it to stack
        if (result.empty()|| heights[result.peek()] <= heights[i])
            result.push(i++);
        else {
            // If this bar is lower than top of stack,
            // then calculate area of rectangle with
            // stack top as the smallest (or minimum
            // height) bar. 'i' is 'right index' for the
            // top and element before top in stack is
            // 'left index'
            top_val = heights[result.peek()];
            result.pop();
            area = top_val * i;

            if (!result.empty())
                area= top_val * (i - result.peek() - 1);
            max_area = Math.max(area, max_area);
            }
    }

    // Now pop the remaining bars from stack and
    // calculate area with every popped bar as the
    // smallest bar
    while (!result.empty()) {
        top_val = heights[result.peek()];
        result.pop();
        area = top_val * i;
        if (!result.empty())
            area = top_val * (i - result.peek() - 1);

        max_area = Math.max(area, max_area);
    }
    return max_area;
}

int maxRectangle(int R, int C, int A[][])
    {
        // Calculate area for first row and initialize it as
        // result
        int result = largestRectangleArea(A[0]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

            // Update result if area with current row (as
            // last row of rectangle) is more
            result = Math.max(result, largestRectangleArea(A[i]));
        }

        return result;
    }
