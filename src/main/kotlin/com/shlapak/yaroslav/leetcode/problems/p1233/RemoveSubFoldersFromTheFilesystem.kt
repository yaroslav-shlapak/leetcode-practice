package com.shlapak.yaroslav.leetcode.problems.p1233

/**
 * LeetCode 1233: Remove Sub-Folders from the Filesystem.
 *
 * Returns the folders that have no ancestor in the supplied paths.
 *
 * @see <a href="https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/">Problem statement</a>
 */
class RemoveSubFoldersFromTheFilesystem {
    /**
     * Sorts a copy of [folder] so each parent precedes its contiguous group of descendants.
     * Only the last retained folder can be an ancestor of the current path. A matching
     * prefix must end at a slash boundary: /a is not an ancestor of /ab.
     * Returns paths in lexicographic order without modifying the input.
     *
     * Time: O(n log n * L), where n is the folder count and L the maximum path length.
     * Space: O(n), including the sorted references, sorting workspace, and result.
     */
    fun removeSubfolders(folder: Array<String>): List<String> {
        val result = mutableListOf<String>()
        for (path in folder.sorted()) {
            val parent = result.lastOrNull()
            if (parent == null || !path.startsWith(parent) ||
                path.length <= parent.length || path[parent.length] != '/') {
                result.add(path)
            }
        }
        return result
    }
}

// TODO review
