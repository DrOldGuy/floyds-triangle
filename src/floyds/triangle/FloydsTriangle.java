package floyds.triangle;

/**
 * This class generates a Floyd's Triangle. The triangle follows the following
 * rules:
 * 
 * <ol>
 * <li>The first row is row number 1.</li>
 * <li>Each row has the same number of elements as the row number.</li>
 * <li>The first element (in the first row) is 1.</li>
 * <li>Each element is numbered successively over the entire triangle.</li>
 * <li>The last element on any row is calculated by: row * (row + 1) / 2</li>
 * <li>Each cell is the width of the largest number plus 1.</li>
 * <li>The numbers in each cell are right-justified</li>
 * </ol>
 *
 */
public class FloydsTriangle {
  /* Set the size (number of rows) of the triangle here. */
  int sizeOfTriangle = 15;

  /**
   * Entry point for a Java application. The JVM starts executing code here.
   * 
   * @param args Unused
   */
  public static void main(String[] args) {
    new FloydsTriangle().run();
  }

  /**
   * This method is called by the main method to start program execution. It is
   * an instance method and is able to access the instance variable
   * <em>sizeOfTriangle</em>. This method simply calls
   * {@link #generateTriangle(int)}.
   */
  private void run() {
    generateTriangle(sizeOfTriangle);
  }

  /**
   * This method finds the maximum cell width and then it generates the
   * triangle.
   */
  private void generateTriangle(int numRows) {
    int maxCellWidth = findLastElementCellWidth(numRows);

    for(int row = 1; row <= sizeOfTriangle; row += 1) {
      generateRow(row, maxCellWidth);
    }
  }

  /**
   * Generate a row and write it to the console.
   * 
   * @param row The row number.
   * @param cellWidth The width of the largest number. For example, if the
   *        largest number is 120, the cell width is 3.
   */
  private void generateRow(int row, int cellWidth) {
    /*
     * The starting number of any row is the last number of the prior row plus
     * 1.
     */
    int start = findLastElementInRow(row - 1) + 1;

    /* Store the row contents as it is built. */
    StringBuilder rowBuilder = new StringBuilder();

    /*
     * Each cell is the width of the largest cell. If the cell is not the first
     * on a row, add another space so that cells come out like "118 119 120" and
     * not "118119120".
     */
    for(int cellNum = 0; cellNum < row; cellNum += 1) {
      int width = cellNum == 0 ? cellWidth : cellWidth + 1;
      String cellValue = rightJustify(cellNum + start, width);
      rowBuilder.append(cellValue);
    }

    System.out.println(rowBuilder);
  }

  /**
   * Right justify the value in the cell. This is done by adding spaces onto the
   * front of the value converted to a String until it is the desired width.
   * 
   * @param num The value to justify
   * @param cellWidth The width of the cell
   * @return The right-justified value
   */
  private String rightJustify(int num, int cellWidth) {
    /* Convert the integer value to a String. */
    String cellContent = Integer.toString(num);

    while (cellContent.length() < cellWidth) {
      cellContent = " " + cellContent;
    }

    return cellContent;
  }

  /**
   * This finds the cell width of the last element in the given row. This method
   * first finds the last element in the row. It then divides the number by 10
   * using integer division to lop off the last character. The number of times
   * it can do this before the number is zero results in the width of the
   * number. For example, using 120 as the last element in the row:
   * 
   * <table>
   * <tr>
   * <th>Initial Value</th>
   * <th>New Value</th>
   * <th>Width Counter</th>
   * </tr>
   * <tr>
   * <td>120</td>
   * <td>12</td>
   * <td>1</td>
   * </tr>
   * <tr>
   * <td>12</td>
   * <td>1</td>
   * <td>2</td>
   * </tr>
   * <tr>
   * <td>1</td>
   * <td>0</td>
   * <td>3</td>
   * </tr>
   * </table>
   * 
   * @param row The row number
   * @return The width (in characters) of the last element in the row.
   */
  private int findLastElementCellWidth(int row) {
    int lastRowElement = findLastElementInRow(row);
    int width = 0;

    while (lastRowElement > 0) {
      lastRowElement /= 10;
      width += 1;
    }

    return width;
  }

  /**
   * This finds the last element (number) in a triangle row. It uses the
   * formula: last value = row * (row + 1) / 2.
   * 
   * @param row The row number on which to find the last cell value.
   * @return The last cell value.
   */
  private int findLastElementInRow(int row) {
    return row * (row + 1) / 2;
  }
}
