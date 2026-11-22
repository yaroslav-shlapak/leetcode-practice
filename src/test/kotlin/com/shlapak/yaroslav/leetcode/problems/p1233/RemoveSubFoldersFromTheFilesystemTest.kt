package com.shlapak.yaroslav.leetcode.problems.p1233

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [RemoveSubFoldersFromTheFilesystem] for ancestry, path boundaries, and input preservation.
 */
class RemoveSubFoldersFromTheFilesystemTest : FreeSpec({
    val approaches = listOf(
        "sorting" to RemoveSubFoldersFromTheFilesystem()::removeSubfolders
    )
    for ((name, removeSubfolders) in approaches) {
        name - {
            // Normalize result order while preserving duplicate counts.
            fun remove(folder: Array<String>) = removeSubfolders(folder).sorted()

            "removes descendants across separate branches" {
                remove(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")) shouldBe
                    listOf("/a", "/c/d", "/c/f")
            }

            "removes all depths beneath a parent" {
                remove(arrayOf("/a", "/a/b/c", "/a/b/d")) shouldBe listOf("/a")
            }

            "keeps similar names that are not descendants" {
                remove(arrayOf("/a/b/c", "/a/b/ca", "/a/b/d")) shouldBe
                    listOf("/a/b/c", "/a/b/ca", "/a/b/d")
                remove(arrayOf("/ab/c", "/a/b", "/ab", "/a")) shouldBe
                    listOf("/a", "/ab")
            }

            "finds parents after their descendants without changing the input" {
                val folders = arrayOf("/z/y/x", "/a/b/c", "/z", "/a/b", "/a")
                val original = folders.toList()

                remove(folders) shouldBe listOf("/a", "/z")
                folders.toList() shouldBe original
            }

            "keeps a single folder and unrelated roots" {
                remove(arrayOf("/only")) shouldBe listOf("/only")
                remove(arrayOf("/z", "/b", "/a")) shouldBe listOf("/a", "/b", "/z")
            }
        }
    }
})

// TODO review
