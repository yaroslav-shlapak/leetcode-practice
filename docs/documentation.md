# Kotlin documentation convention

Keep problem context on the main type, implementation details beside the relevant
approach, and reusable contracts on shared types and helpers. Apply this convention
to production sources, tests, and examples.

## Problem context

Each problem source file has one problem KDoc attached to its main type. Use the
official problem number and title, one sentence describing the task, and a link
to the canonical problem statement:

```kotlin
/**
 * LeetCode 15: 3Sum.
 *
 * Finds unique triplets whose sum is zero.
 *
 * @see <a href="https://leetcode.com/problems/3sum/">Problem statement</a>
 */
class ThreeSum {
```

When a file contains several top-level implementations, attach the problem KDoc
to the type matching the filename when possible. Other approaches share that
context. Document a variant when its tradeoffs, assumptions, or limitations need
explanation; avoid comments that merely repeat its name.

Do not copy the full statement, sample cases, or constraint list. Keep examples
that explain the implementation and constraints that justify a particular choice,
such as fixed-width bit operations or an assumption about sorted input. Problem
summaries describe the task; they do not certify that every attempt is correct.
Clearly label unfinished or known-broken implementations beside the affected code.

## Implementation details

Describe the approach before stating complexity or side effects:

```kotlin
/**
 * Searches a sorted array by repeatedly halving the candidate interval.
 *
 * Requires [nums] to be sorted in ascending order.
 * Returns -1 when [target] is absent. The input is not modified.
 *
 * Time: O(log n).
 * Space: O(1).
 */
fun search(nums: IntArray, target: Int): Int
```

- State complexity only after checking the actual implementation, including
  helper calls, sorting, recursion, and intermediate collections.
- Use plain `Time:` and `Space:` paragraphs. Define variables when their meaning
  is not obvious. State whether space includes the result and sorting workspace.
- Document input mutation, aliasing, ordering requirements, and important edge cases.
- Preserve useful reasoning, invariants, and walkthroughs near the approach they explain.
- Use fenced code blocks for multiline examples. Use ordinary comments for notes
  inside a function; KDoc belongs to declarations.
- Link parameters and types with `[nums]` and `[TreeNode]` when they are in scope.
- Add `@param`, `@return`, and `@throws` only when they clarify the contract.
- Do not invent tags such as `@complexity` or fill missing analysis with guesses.

## Shared types and test support

Explain the type's role and use `@property` for meaningful public state:

```kotlin
/**
 * Mutable binary-tree node using LeetCode's value naming.
 *
 * @property `val` Value stored in this node.
 * @property left Left child, or null.
 * @property right Right child, or null.
 */
class TreeNode(var `val`: Int)
```

Helpers should document observable behavior, especially null receivers, truncation,
cycle assumptions, and shallow versus deep copies. Describe the implementation
that exists rather than the behavior suggested by its name.

## Tests and examples

Keep test KDoc short and link the actual implementation under test:

```kotlin
/**
 * Tests [ThreeSumLegacy].
 *
 * Loads larger input and expected-output cases from classpath JSON fixtures.
 */
class ThreeSumTest : FreeSpec({
```

Link nested approaches when the tests instantiate them. Explain fixture sources
only when relevant. Test KDoc describes coverage; it does not claim that tests
pass. Example files should explain what they demonstrate or how to use the template.

## Formatting and review

- Use `/**`, one ` *` prefix per line, and ` */`, aligned with the declaration.
- Start with a complete sentence and separate paragraphs with an empty ` *` line.
- Remove creation dates and authorship boilerplate; use Git history for provenance.
- Avoid duplicate adjacent KDoc blocks and stale fully qualified symbol references.
- Keep prose readable at roughly 100 characters per line; a canonical URL may be longer.
- For documentation-only edits, verify that code tokens and string literals are
  unchanged. Existing repository compilation failures should be reported separately.
