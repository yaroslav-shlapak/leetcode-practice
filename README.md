# LeetCode Practice

Kotlin solutions and Kotest tests in a single Gradle module.

See the [Kotlin documentation convention](docs/documentation.md) for problem KDoc,
implementation notes, shared-type contracts, and test documentation.

## Layout

All Kotlin packages below start with `com.shlapak.yaroslav.leetcode`.

```text
src/
├── main/kotlin/com/shlapak/yaroslav/leetcode/
│   ├── problems/p0001/TwoSum.kt
│   ├── problems/p0015/ThreeSum.kt
│   └── common/                 # Shared ListNode, TreeNode, and Node types
└── test/
    ├── kotlin/com/shlapak/yaroslav/leetcode/
    │   ├── problems/p0015/ThreeSumTest.kt
    │   ├── support/            # Fixture builders and formatting helpers
    │   └── examples/           # Test template and Kotest isolation example
    └── resources/problems/p0015/
        ├── input.json
        └── expected.json
```

## Adding a solution

1. Create `src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/pNNNN/`, padding the problem ID to at least four digits.
2. Use the matching package, for example `com.shlapak.yaroslav.leetcode.problems.p0015`.
3. Give the file and primary class descriptive names, such as `ThreeSum.kt` and `ThreeSum`. Keep alternative approaches in the same package. Existing `Legacy` and `Alternative` classes preserve earlier implementations.
4. Include the problem URL and document the approach and complexity when useful.
5. Add a matching `ThreeSumTest.kt` under the same package in `src/test/kotlin`. Keep fixtures under `src/test/resources/problems/p0015` and load them through the classpath.
6. Add the solution and test links to the index below. Topic tags are navigation hints; a problem has only one package regardless of its topics.

Shared production types belong in `common`. Helpers used only by tests belong in `src/test/kotlin/.../support`. Keep problem-specific types beside the solution.

## Running tests

Use JDK 17 for the existing Gradle wrapper. The wrapper cannot run on the default Java 25 environment used during this migration.

```powershell
$env:JAVA_HOME = 'C:\path\to\jdk-17'
.\gradlew.bat test
.\gradlew.bat test --tests 'com.shlapak.yaroslav.leetcode.problems.p0015.ThreeSumTest'
```

On macOS or Linux, set `JAVA_HOME` to your JDK 17 installation and use `./gradlew`.

The repository contains unfinished solutions and existing compilation errors. Gradle compiles all production sources before running any test, so a filtered test command also requires those errors to be resolved. The structure migration preserves these implementations; it does not exclude unfinished files from the build.

## Problem index

The index lists existing source files, including unfinished solutions. A test link indicates that test source exists, not that it currently passes.

| ID | Solution | Topics | Tests |
| --- | --- | --- | --- |
| 1 | [Two Sum](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0001/TwoSum.kt) | arrays | — |
| 2 | [Add Two Numbers](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0002/AddTwoNumbers.kt) | linked-lists | — |
| 3 | [Longest Substring Without Repeating Characters](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0003/LongestSubstringWithoutRepeatingCharacters.kt) | trees, strings | — |
| 4 | [Median Of Two Sorted Arrays](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0004/MedianOfTwoSortedArrays.kt) | arrays | — |
| 5 | [Longest Palindromic Substring](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0005/LongestPalindromicSubstring.kt) | trees, strings | — |
| 6 | [Zig Zag Conversion](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0006/ZigZagConversion.kt) | strings | — |
| 7 | [Reverse Integer](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0007/ReverseInteger.kt) | — | — |
| 8 | [String To Integer](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0008/StringToInteger.kt) | strings | — |
| 9 | [Palindrome Number](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0009/PalindromeNumber.kt) | strings | — |
| 10 | [Regular Expression Matching](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0010/RegularExpressionMatching.kt) | — | [RegularExpressionMatchingTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0010/RegularExpressionMatchingTest.kt) |
| 11 | [Container With Most Water](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0011/ContainerWithMostWater.kt) | — | [ContainerWithMostWaterTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0011/ContainerWithMostWaterTest.kt) |
| 12 | [Integer To Roman](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0012/IntegerToRoman.kt) | strings | [IntegerToRomanTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0012/IntegerToRomanTest.kt) |
| 13 | [Roman To Integer](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0013/RomanToInteger.kt) | strings | [RomanToIntegerTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0013/RomanToIntegerTest.kt) |
| 14 | [Longest Common Prefix](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0014/LongestCommonPrefix.kt) | — | [LongestCommonPrefixTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0014/LongestCommonPrefixTest.kt) |
| 15 | [Three Sum](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0015/ThreeSum.kt) | arrays | [ThreeSumTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0015/ThreeSumTest.kt) |
| 16 | [Three Sum Closest](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0016/ThreeSumClosest.kt) | arrays | [ThreeSumClosestTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0016/ThreeSumClosestTest.kt) |
| 17 | [Letter Combinations Of APhone Number](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0017/LetterCombinationsOfAPhoneNumber.kt) | strings, arrays | [LetterCombinationsOfAPhoneNumberTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0017/LetterCombinationsOfAPhoneNumberTest.kt) |
| 18 | [Four Sum](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0018/FourSum.kt) | arrays | [FourSumTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0018/FourSumTest.kt) |
| 19 | [Remove Nth Node From End Of List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0019/RemoveNthNodeFromEndOfList.kt) | linked-lists | [RemoveNthNodeFromEndOfListTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0019/RemoveNthNodeFromEndOfListTest.kt) |
| 20 | [Valid Parentheses](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0020/ValidParentheses.kt) | strings | [ValidParenthesesTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0020/ValidParenthesesTest.kt) |
| 21 | [Merge Two Sorted Lists](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0021/MergeTwoSortedLists.kt) | — | [MergeTwoSortedListsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0021/MergeTwoSortedListsTest.kt) |
| 22 | [Generate Parentheses](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0022/GenerateParentheses.kt) | strings | [GenerateParenthesesTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0022/GenerateParenthesesTest.kt) |
| 23 | [Merge KSorted Lists](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0023/MergeKSortedLists.kt) | — | [MergeKSortedListsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0023/MergeKSortedListsTest.kt) |
| 24 | [Swap Nodes In Pairs](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0024/SwapNodesInPairs.kt) | linked-lists | [SwapNodesInPairsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0024/SwapNodesInPairsTest.kt) |
| 25 | [Reverse Nodes In KGroup](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0025/ReverseNodesInKGroup.kt) | — | [ReverseNodesInKGroupTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0025/ReverseNodesInKGroupTest.kt) |
| 26 | [Remove Duplicates From Sorted Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0026/RemoveDuplicatesFromSortedArray.kt) | arrays | [RemoveDuplicatesFromSortedArrayTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0026/RemoveDuplicatesFromSortedArrayTest.kt) |
| 27 | [Remove Element](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0027/RemoveElement.kt) | — | [RemoveElementTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0027/RemoveElementTest.kt) |
| 28 | [Implement Str Str](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0028/ImplementStrStr.kt) | — | [ImplementStrStrTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0028/ImplementStrStrTest.kt) |
| 29 | [Divide Two Integers](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0029/DivideTwoIntegers.kt) | — | [DivideTwoIntegersTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0029/DivideTwoIntegersTest.kt) |
| 30 | [Substring With Concatenation Of All Words](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0030/SubstringWithConcatenationOfAllWords.kt) | trees, strings | [SubstringWithConcatenationOfAllWordsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0030/SubstringWithConcatenationOfAllWordsTest.kt) |
| 31 | [Next Permutation](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0031/NextPermutation.kt) | arrays | [NextPermutationTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0031/NextPermutationTest.kt) |
| 32 | [Longest Valid Parentheses](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0032/LongestValidParentheses.kt) | strings | [LongestValidParenthesesTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0032/LongestValidParenthesesTest.kt) |
| 33 | [Search In Rotated Sorted Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0033/SearchInRotatedSortedArray.kt) | arrays, binary-search | [SearchInRotatedSortedArrayTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0033/SearchInRotatedSortedArrayTest.kt) |
| 34 | [Find First And Last Position Of Element In Sorted Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0034/FindFirstAndLastPositionOfElementInSortedArray.kt) | arrays | [FindFirstAndLastPositionOfElementInSortedArrayTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0034/FindFirstAndLastPositionOfElementInSortedArrayTest.kt) |
| 35 | [Search Insert Position](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0035/SearchInsertPosition.kt) | binary-search | [SearchInsertPositionTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0035/SearchInsertPositionTest.kt) |
| 36 | [Valid Sudoku](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0036/ValidSudoku.kt) | — | [ValidSudokuTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0036/ValidSudokuTest.kt) |
| 37 | [Sudoku Solver](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0037/SudokuSolver.kt) | — | [SudokuSolverTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0037/SudokuSolverTest.kt) |
| 38 | [Count And Say](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0038/CountAndSay.kt) | — | [CountAndSayTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0038/CountAndSayTest.kt) |
| 39 | [Combination Sum](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0039/CombinationSum.kt) | arrays | [CombinationSumTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0039/CombinationSumTest.kt) |
| 40 | [Combination Sum2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0040/CombinationSum2.kt) | arrays | [CombinationSum2Test](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0040/CombinationSum2Test.kt) |
| 41 | [First Missing Positive](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0041/FirstMissingPositive.kt) | — | [FirstMissingPositiveTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0041/FirstMissingPositiveTest.kt) |
| 42 | [Trapping Rain Water](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0042/TrappingRainWater.kt) | — | [TrappingRainWaterTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0042/TrappingRainWaterTest.kt) |
| 43 | [Multiply Strings](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0043/MultiplyStrings.kt) | strings | [MultiplyStringsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0043/MultiplyStringsTest.kt) |
| 46 | [Permutations](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0046/Permutations.kt) | arrays | [PermutationsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0046/PermutationsTest.kt) |
| 47 | [Permutations2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0047/Permutations2.kt) | arrays | [Permutations2Test](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0047/Permutations2Test.kt) |
| 48 | [Rotate Image](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0048/RotateImage.kt) | — | [RotateImageTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0048/RotateImageTest.kt) |
| 49 | [Group Anagrams](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0049/GroupAnagrams.kt) | strings | [GroupAnagramsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0049/GroupAnagramsTest.kt) |
| 50 | [Pow XN](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0050/PowXN.kt) | — | [PowXNTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0050/PowXNTest.kt) |
| 53 | [Maximum Subarray](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0053/MaximumSubarray.kt) | arrays | [MaximumSubarrayTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0053/MaximumSubarrayTest.kt) |
| 54 | [Spiral Matrix](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0054/SpiralMatrix.kt) | arrays | [SpiralMatrixTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0054/SpiralMatrixTest.kt) |
| 55 | [Jump Game](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0055/JumpGame.kt) | — | — |
| 56 | [Merge Intervals](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0056/MergeIntervals.kt) | arrays | — |
| 57 | [Insert Interval](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0057/InsertInterval.kt) | arrays | — |
| 61 | [Rotate Linked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0061/RotateLinkedList.kt) | linked-lists | — |
| 66 | [Plus One](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0066/PlusOne.kt) | — | — |
| 70 | [Climbing Stairs](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0070/ClimbingStairs.kt) | — | — |
| 73 | [Set Matrix Zeros](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0073/SetMatrixZeros.kt) | arrays | — |
| 74 | [Search2d Matrix](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0074/Search2dMatrix.kt) | arrays | — |
| 75 | [Sort Colors](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0075/SortColors.kt) | — | — |
| 77 | [Combinations](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0077/Combinations.kt) | arrays | — |
| 78 | [Subsets](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0078/Subsets.kt) | — | — |
| 86 | [Partition List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0086/PartitionList.kt) | — | — |
| 88 | [Merge Sorted Arrays](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0088/MergeSortedArrays.kt) | arrays | — |
| 89 | [Grey Code](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0089/GreyCode.kt) | — | — |
| 92 | [Reverse Linked List2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0092/ReverseLinkedList2.kt) | linked-lists | — |
| 100 | [Same Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0100/SameTree.kt) | trees | — |
| 101 | [Is Symmetric Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0101/IsSymmetricTree.kt) | trees | — |
| 102 | [Binary Tree Level Order Traversal](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0102/BinaryTreeLevelOrderTraversal.kt) | trees | — |
| 104 | [Maximum Depth Of Binary Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0104/MaximumDepthOfBinaryTree.kt) | trees | — |
| 108 | [Sorted Array To Binary Search Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0108/SortedArrayToBinarySearchTree.kt) | trees, arrays, binary-search | — |
| 112 | [Path Sum](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0112/PathSum.kt) | arrays | — |
| 113 | [Path Sum2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0113/PathSum2.kt) | arrays | — |
| 114 | [Flatten Binary Tree To Linked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0114/FlattenBinaryTreeToLinkedList.kt) | trees, linked-lists | — |
| 121 | [Best Time To Buy And Sell Stocks](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0121/BestTimeToBuyAndSellStocks.kt)<br>[Best Time To Buy Or Sell Stock](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0121/BestTimeToBuyOrSellStock.kt) | arrays | — |
| 125 | [Valid Palindrome](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0125/ValidPalindrome.kt) | strings | — |
| 128 | [Longest Consecutive Sequence](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0128/LongestConsecutiveSequence.kt) | — | — |
| 133 | [Clone Graph](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0133/CloneGraph.kt) | graphs | — |
| 136 | [Single Number](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0136/SingleNumber.kt) | — | — |
| 137 | [Single Number2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0137/SingleNumber2.kt) | — | — |
| 138 | [Copy With Random Pointer](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0138/CopyWithRandomPointer.kt) | linked-lists | — |
| 139 | [Word Break](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0139/WordBreak.kt) | strings | — |
| 141 | [Linked List Cycle](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0141/LinkedListCycle.kt) | linked-lists | — |
| 143 | [Reorder List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0143/ReorderList.kt) | — | — |
| 146 | [LRUCache](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0146/LRUCache.kt) | design | [LRUCacheTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0146/LRUCacheTest.kt) |
| 150 | [Evaluate Reverse Polish Notation](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0150/EvaluateReversePolishNotation.kt) | — | — |
| 151 | [Reverse Words In String](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0151/ReverseWordsInString.kt) | strings | — |
| 153 | [Find Minimum In Rotated Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0153/FindMinimumInRotatedArray.kt) | arrays, binary-search | — |
| 155 | [Min Stack](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0155/MinStack.kt) | design | — |
| 162 | [Find Peak Element](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0162/FindPeakElement.kt) | binary-search | — |
| 165 | [Compare Version Numbers](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0165/CompareVersionNumbers.kt) | — | — |
| 167 | [Two Sum2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0167/TwoSum2.kt) | arrays | — |
| 169 | [Majority Element](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0169/MajorityElement.kt) | — | — |
| 189 | [Rotate Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0189/RotateArray.kt) | arrays | — |
| 199 | [Binary Tree Right Side View](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0199/BinaryTreeRightSideView.kt) | trees | — |
| 200 | [Number Of Islands](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0200/NumberOfIslands.kt) | graphs | — |
| 206 | [Reverse Linked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0206/ReverseLinkedList.kt) | linked-lists | — |
| 207 | [Course Schedule](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0207/CourseSchedule.kt) | graphs | — |
| 208 | [Implement Trie](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0208/ImplementTrie.kt) | trie | — |
| 211 | [Word Dictionary](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0211/WordDictionary.kt) | strings, trie | — |
| 215 | [Kth Largest Element In Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0215/KthLargestElementInArray.kt) | arrays | — |
| 217 | [Contains Duplicate](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0217/ContainsDuplicate.kt) | — | — |
| 219 | [Contains Duplicate2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0219/ContainsDuplicate2.kt) | — | — |
| 226 | [Invert Binary Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0226/InvertBinaryTree.kt) | trees | — |
| 232 | [Queue On Two Stacks](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0232/QueueOnTwoStacks.kt) | design | — |
| 234 | [Palindrome Linked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0234/PalindromeLinkedList.kt) | linked-lists, strings | — |
| 235 | [Lowest Common Ancestor](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0235/LowestCommonAncestor.kt) | — | — |
| 236 | [Lowest Common Ancestor](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0236/LowestCommonAncestor.kt) | — | — |
| 238 | [Product Of Array Except Self](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0238/ProductOfArrayExceptSelf.kt) | arrays | — |
| 242 | [Valid Anagram](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0242/ValidAnagram.kt) | strings | [ValidAnagramTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0242/ValidAnagramTest.kt) |
| 257 | [Binary Tree Paths](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0257/BinaryTreePaths.kt) | trees | — |
| 258 | [Add Digits](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0258/AddDigits.kt) | — | — |
| 268 | [Missing Number](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0268/MissingNumber.kt) | — | — |
| 271 | [Encode And Decode The String](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0271/EncodeAndDecodeTheString.kt) | strings | — |
| 278 | [First Bad Version](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0278/FirstBadVersion.kt) | — | — |
| 279 | [Perfect Squares](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0279/PerfectSquares.kt) | — | — |
| 283 | [Move Zeros](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0283/MoveZeros.kt) | — | — |
| 303 | [Range Sum Query Immutable](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0303/RangeSumQueryImmutable.kt) | arrays | — |
| 310 | [Minimum Height Trees](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0310/MinimumHeightTrees.kt) | trees | — |
| 316 | [Remove Duplicate Letters](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0316/RemoveDuplicateLetters.kt) | strings | — |
| 324 | [Wiggle Sort2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0324/WiggleSort2.kt) | — | — |
| 328 | [Odd Even Linked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0328/OddEvenLinkedList.kt) | linked-lists | — |
| 347 | [Top KFrequent Elements](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0347/TopKFrequentElements.kt) | — | — |
| 371 | [Sum Of Two Integers](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0371/SumOfTwoIntegers.kt) | arrays | — |
| 380 | [Insert Delete Get Random](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0380/InsertDeleteGetRandom.kt) | design | — |
| 383 | [Ransom Note](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0383/RansomNote.kt) | — | — |
| 392 | [Is Subsequence](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0392/IsSubsequence.kt) | — | — |
| 394 | [Decode String](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0394/DecodeString.kt) | strings | — |
| 402 | [Remove KDigits](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0402/RemoveKDigits.kt) | — | — |
| 409 | [Longest Palindrome](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0409/LongestPalindrome.kt) | strings | — |
| 415 | [Add Strings](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0415/AddStrings.kt) | strings | — |
| 424 | [Longest Repeating Character Replacement](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0424/LongestRepeatingCharacterReplacement.kt) | — | — |
| 438 | [Find All Anagrams In String](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0438/FindAllAnagramsInString.kt) | strings | [FindAllAnagramsInStringTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p0438/FindAllAnagramsInStringTest.kt) |
| 452 | [Minimum Number Of Arrows To Burst Ballons](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0452/MinimumNumberOfArrowsToBurstBallons.kt) | — | — |
| 454 | [Four Sum2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0454/FourSum2.kt) | arrays | — |
| 456 | [Task132 Pattern](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0456/Task132Pattern.kt) | — | — |
| 496 | [Next Greater Element1](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0496/NextGreaterElement1.kt) | — | — |
| 525 | [Contiguous Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0525/ContiguousArray.kt) | arrays | — |
| 532 | [KDiff Pairs In Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0532/KDiffPairsInArray.kt) | arrays | — |
| 538 | [Convert BSTto Greater Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0538/ConvertBSTtoGreaterTree.kt) | trees | — |
| 543 | [Maximum Diameter Of Binary Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0543/MaximumDiameterOfBinaryTree.kt) | trees | — |
| 547 | [Number Of Provinces](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0547/NumberOfProvinces.kt) | graphs | — |
| 560 | [Sub Array Sums Equals K](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0560/SubArraySumsEqualsK.kt) | arrays | — |
| 572 | [Subtree Of Another Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0572/SubtreeOfAnotherTree.kt) | trees | — |
| 623 | [Add One Row To Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0623/AddOneRowToTree.kt) | trees | — |
| 648 | [Replace Words](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0648/ReplaceWords.kt) | strings, trie | — |
| 653 | [Two Sum4](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0653/TwoSum4.kt) | arrays | — |
| 658 | [Closest KElements](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0658/ClosestKElements.kt) | — | — |
| 670 | [Max Swap](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0670/MaxSwap.kt) | — | — |
| 680 | [Valid Palindrome2](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0680/ValidPalindrome2.kt) | strings | — |
| 682 | [Baseball Game](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0682/BaseballGame.kt) | — | — |
| 692 | [Top KFrequent Words](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0692/TopKFrequentWords.kt) | strings | — |
| 702 | [Search In Sorted Array Of Unknown Size](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0702/SearchInSortedArrayOfUnknownSize.kt) | arrays, binary-search | — |
| 703 | [Largest Element In Stream](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0703/LargestElementInStream.kt) | design | — |
| 704 | [Binary Search](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0704/BinarySearch.kt) | binary-search | — |
| 729 | [My Calendar1](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0729/MyCalendar1.kt) | design | — |
| 733 | [Flood Fill](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0733/FloodFill.kt) | graphs | — |
| 735 | [Asteroid Collision](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0735/AsteroidCollision.kt) | — | — |
| 739 | [Daily Temperatures](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0739/DailyTemperatures.kt) | — | — |
| 752 | [Open The Lock](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0752/OpenTheLock.kt) | — | — |
| 797 | [All Paths From Source To Target](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0797/AllPathsFromSourceToTarget.kt) | graphs | — |
| 814 | [Binary Tree Pruning](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0814/BinaryTreePruning.kt) | trees | — |
| 821 | [Shortest Distance To ACharacter](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0821/ShortestDistanceToACharacter.kt) | — | — |
| 833 | [Find And Replace In String](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0833/FindAndReplaceInString.kt) | strings | — |
| 844 | [Backspace String Compare](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0844/BackspaceStringCompare.kt) | strings | — |
| 853 | [Car Fleet](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0853/CarFleet.kt) | — | — |
| 875 | [Koko Eating Bananas](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0875/KokoEatingBananas.kt) | — | — |
| 876 | [Middle Of Linked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0876/MiddleOfLinkedList.kt) | linked-lists | — |
| 904 | [Fruit Into Buckets](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0904/FruitIntoBuckets.kt) | — | — |
| 917 | [Reverse Only Letters](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0917/ReverseOnlyLetters.kt) | strings | — |
| 934 | [Shortest Bridge](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0934/ShortestBridge.kt) | graphs | — |
| 935 | [Knight Dialler](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0935/KnightDialler.kt) | — | — |
| 948 | [Bag Of Tokens](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0946/BagOfTokens.kt) | — | — |
| 977 | [Squares Of Sorted Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0977/SquaresOfSortedArray.kt) | arrays | — |
| 981 | [Time Based Key Value Store](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0981/TimeBasedKeyValueStore.kt) | design | — |
| 994 | [Rooting Oranges](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0994/RootingOranges.kt) | graphs | — |
| 997 | [Find The Town Judge](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p0997/FindTheTownJudge.kt) | graphs | — |
| 1011 | [Capacity To Ship Packages Within DDays](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1011/CapacityToShipPackagesWithinDDays.kt) | — | — |
| 1046 | [Last Stone Weight](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1046/LastStoneWeight.kt) | — | — |
| 1288 | [Remove Covered Intervals](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1288/RemoveCoveredIntervals.kt) | arrays | — |
| 1306 | [Jump Game3](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1306/JumpGame3.kt) | — | — |
| 1328 | [Break APalindrome](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1328/BreakAPalindrome.kt) | strings | — |
| 1339 | [Maximum Product Of Splitted Binary Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1339/MaximumProductOfSplittedBinaryTree.kt) | trees | — |
| 1347 | [Minimum Number Of Steps To Make Two Strings Anagram](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1347/MinimumNumberOfStepsToMakeTwoStringsAnagram.kt) | strings | [MinimumNumberOfStepsToMakeTwoStringsAnagramTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p1347/MinimumNumberOfStepsToMakeTwoStringsAnagramTest.kt) |
| 1381 | [Custom Stack](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1381/CustomStack.kt) | design | — |
| 1399 | [Count Largest Group](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1399/CountLargestGroup.kt) | — | — |
| 1403 | [Minimum Subsequence In Non Increasing](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1403/MinimumSubsequenceInNonIncreasing.kt) | — | — |
| 1436 | [Destination City](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1436/DestinationCity.kt) | — | — |
| 1448 | [Count Good Nodes In Binary Tree](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1448/CountGoodNodesInBinaryTree.kt) | trees | — |
| 1475 | [Final Prices With Special Discount In Shop](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1475/FinalPricesWithSpecialDiscountInShop.kt) | — | — |
| 1534 | [Count Good Triplets](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1534/CountGoodTriplets.kt) | arrays | — |
| 1574 | [Shortest Subarray To Be Removed To Make Array Sorted](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1574/ShortestSubarrayToBeRemovedToMakeArraySorted.kt) | arrays | — |
| 1743 | [Restore The Array From Adjacent Pairs](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1743/RestoreTheArrayFromAdjacentPairs.kt) | arrays | — |
| 1768 | [Merge Strings Alternately](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1768/MergeStringsAlternately.kt) | strings | — |
| 1769 | [Minimum Number Of Operations To Move All Balls To Each Box](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1769/MinimumNumberOfOperationsToMoveAllBallsToEachBox.kt) | — | — |
| 1791 | [Find Center Of Star Graph](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1791/FindCenterOfStarGraph.kt) | graphs | — |
| 1855 | [Maximum Distance Between APair Of Values](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1855/MaximumDistanceBetweenAPairOfValues.kt) | — | — |
| 1913 | [Maximum Product Difference Between Two Pairs](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1913/MaximumProductDifferenceBetweenTwoPairs.kt) | — | — |
| 1971 | [Find If Path Exists In Graph](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p1971/FindIfPathExistsInGraph.kt) | graphs | — |
| 2037 | [Minimum Number Of Moves To Seat Everyone](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2037/MinimumNumberOfMovesToSeatEveryone.kt) | — | — |
| 2062 | [Count Vowel Substrings](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2062/CountVowelSubstrings.kt) | trees, strings | — |
| 2095 | [Delete The Middle Node In ALinked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2095/DeleteTheMiddleNodeInALinkedList.kt) | linked-lists | — |
| 2099 | [Find Subsequence Of Length KWith Largest Sum](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2099/FindSubsequenceOfLengthKWithLargestSum.kt) | arrays | — |
| 2130 | [Maximum Twin Sum Of ALinked List](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2130/MaximumTwinSumOfALinkedList.kt) | linked-lists, arrays | — |
| 2196 | [Create Binary Tree From Descriptions](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2196/CreateBinaryTreeFromDescriptions.kt) | trees | — |
| 2233 | [Max Product After KIncrements](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2233/MaxProductAfterKIncrements.kt) | — | — |
| 2273 | [Find Resultant Array After Removing Anagrams](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2273/FindResultantArrayAfterRemovingAnagrams.kt) | strings, arrays | [FindResultantArrayAfterRemovingAnagramsTest](src/test/kotlin/com/shlapak/yaroslav/leetcode/problems/p2273/FindResultantArrayAfterRemovingAnagramsTest.kt) |
| 2337 | [Move Pieces To Obtain AString](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2337/MovePiecesToObtainAString.kt) | strings | — |
| 2390 | [Removing Stars From String](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2390/RemovingStarsFromString.kt) | strings | — |
| 2606 | [Find Substring With Max Cost](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2606/FindSubstringWithMaxCost.kt) | trees, strings | — |
| 2657 | [Find Common Prefix](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2657/FindCommonPrefix.kt) | — | — |
| 2799 | [Count Complete Subarrays In Array](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p2799/CountCompleteSubarraysInArray.kt) | arrays | — |
| 3026 | [Maximum Good Subarray Sum](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p3026/MaximumGoodSubarraySum.kt) | arrays | — |
| 3071 | [Minimum Operations To Write Y](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p3071/MinimumOperationsToWriteY.kt) | — | — |
| 3075 | [Maximize Happiness Of Selected Children](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p3075/MaximizeHappinessOfSelectedChildren.kt) | — | — |
| 3195 | [Find The Minimum Area To Cover All Ones](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p3195/FindTheMinimumAreaToCoverAllOnes.kt) | — | — |
| 3216 | [Lexicographically Smallest String After ASwap](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p3216/LexicographicallySmallestStringAfterASwap.kt) | graphs, strings | — |
| 3286 | [Find ASafe Walk Through AGrid](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p3286/FindASafeWalkThroughAGrid.kt) | graphs, arrays | — |
| 3843 | [First Element With Unique Frequency](src/main/kotlin/com/shlapak/yaroslav/leetcode/problems/p3843/FirstElementWithUniqueFrequency.kt) | — | — |
