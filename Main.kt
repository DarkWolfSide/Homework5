fun main() {
    val matrix = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(1, 2, 3),
        arrayOf(1, 2, 3)
    )

    //451
    val elements = diagonalElements(matrix) + backDiagonalElements(matrix)
    var sum = 0
    for (i in 0 until elements.size) {
        sum += elements[i]
    }
    println("arithmetical = ${sum/elements.size}")

    //452
    println("first + last elements square = ${matrix[0][0]*matrix[0][0] +
            matrix[matrix.size-1][matrix[matrix.size-1].size-1]*matrix[matrix.size-1][matrix[matrix.size-1].size-1]}")

    //453
    println("Sum of elements is: ${sumOfElements(5,10, matrix)}")

    //454
    val squareMatrix = mapToSquare(matrix)
    println("Elements square multiplication is: ${multiplyElements(mapToSquare(matrix))}")

    //455
    val elementes = diagonalElements(matrix) + backDiagonalElements(matrix)
    var mul = 1
    for (i in 0 until elementes.size) {
        mul *= elementes[i]
    }
    println("arithmetical = $mul")

    //456
    println("Positive elements amount is: ${countPositiveElements(matrix)}")

    //457
    println("Sum of odd elements in matrix is: ${sumOfOddElements(matrix)}")

    //458
    val k = 1
    println("Number of elements greather than $k is: ${countElementsGreaterThan(matrix, k)}")

    //459
    println("Multiplication of elements which are < 0 = : ${multiplyElementsLessThanZero(matrix)}")

    //460
    println("Multiplication of square root even elements is: ${multiplyArrayElements(getSquareOfEvenElements(matrix))}")
}
fun multiplyArrayElements(array: IntArray): Int = array.reduce { acc, element -> acc * element }
fun getSquareOfEvenElements(matrix: Array<Array<Int>>): IntArray {
    return matrix.flatMap { it.asIterable() }
        .filter { it % 2 == 0 }
        .map { it * it }
        .toIntArray()
}
fun multiplyElementsLessThanZero(matrix: Array<Array<Int>>): Any {
    val elementsLessThanZero = matrix.flatMap { it.asList() }
        .filter { it < 0 }
    return if (elementsLessThanZero.isEmpty()) {
        "No Element Found"
    } else {
        elementsLessThanZero.fold(1) { acc, value -> acc * value }
    }
}
fun countElementsGreaterThan(matrix: Array<Array<Int>>, k: Int): Int {
    return matrix.flatMap { it.asList() }.count { it > k }
}
fun sumOfOddElements(matrix: Array<Array<Int>>): Int {
    return matrix.flatMap { it.asList() }.filter { it % 2 != 0 }.sum()
}
fun countPositiveElements(matrix: Array<Array<Int>>): Int {
    return matrix.flatMap { it.asList() }.count { it > 0 }
}
fun multiplyElements(matrix: Array<IntArray>): Int {
    val flattenedList = matrix.flatMap { it.toList() }
    return flattenedList.reduce { acc, value -> acc * value }
}
fun mapToSquare(matrix: Array<Array<Int>>): Array<IntArray> {
    return matrix.map { row -> row.map { it * it }.toIntArray() }.toTypedArray()
}
fun sumOfElements(a: Int, b: Int, matrix: Array<Array<Int>>): Int {
    return matrix.sumBy { row -> row.filter { it in a..b }.sum() }
}
fun diagonalElements(matrix: Array<Array<Int>>): List<Int> {
    return matrix.mapIndexed { index, row -> row[index] }
}
fun backDiagonalElements(matrix: Array<Array<Int>>): List<Int> {
    return matrix.mapIndexed { index, row -> row[matrix.size - 1 - index] }
}