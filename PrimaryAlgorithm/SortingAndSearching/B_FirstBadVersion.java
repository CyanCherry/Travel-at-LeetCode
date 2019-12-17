package SortingAndSearching;

public class B_FirstBadVersion {
    static class Solution extends VersionControl {
        Solution(int firstBadVersion) {
            super(firstBadVersion);
        }

        public int firstBadVersion(int n) {
            int lastGoodVersion = 0;
            int firstBadVersion = n;
            while (lastGoodVersion + 1 < firstBadVersion) {
                int middleVersion = lastGoodVersion / 2 + firstBadVersion / 2;
                if (lastGoodVersion % 2 == 1 && firstBadVersion % 2 == 1)
                    middleVersion++;
                if (isBadVersion(middleVersion))
                    firstBadVersion = middleVersion;
                else
                    lastGoodVersion = middleVersion;
            }
            return firstBadVersion;
        }
    }

    private static class VersionControl {
        int firstBadVersion;

        VersionControl(int firstBadVersion) {
            this.firstBadVersion = firstBadVersion;
        }

        boolean isBadVersion(int version) {
            return version >= firstBadVersion;
        }
    }

    public static void main(String[] args) {
        assert new Solution(4).firstBadVersion(5) == 4;
        assert new Solution(1702766719).firstBadVersion(2126753390) == 1702766719;
    }
}
