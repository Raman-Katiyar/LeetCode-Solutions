import java.util.HashMap;
import java.util.Map;

class Solution {
    int MOD = 1_000_000_007;
    long[] s1, s2, lz;

    public int sumCounts(int[] a) {
        int n = a.length;
        s1 = new long[4 * n];
        s2 = new long[4 * n];
        lz = new long[4 * n];

        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int p = map.getOrDefault(a[i], -1);
            upd(1, 0, n - 1, p + 1, i, 1);
            ans = (ans + s2[1]) % MOD;
            map.put(a[i], i);
        }

        return (int) ans;
    }

    void set(int u, int l, int r, long v) {
        long len = r - l + 1;
        s2[u] = (s2[u] + 2 * v % MOD * s1[u] % MOD + len * v % MOD * v % MOD) % MOD;
        s1[u] = (s1[u] + len * v % MOD) % MOD;
        lz[u] = (lz[u] + v) % MOD;
    }

    void push(int u, int l, int r) {
        if (lz[u] != 0) {
            int m = (l + r) >> 1;
            set(u << 1, l, m, lz[u]);
            set(u << 1 | 1, m + 1, r, lz[u]);
            lz[u] = 0;
        }
    }

    void upd(int u, int l, int r, int ql, int qr, long v) {
        if (ql <= l && r <= qr) {
            set(u, l, r, v);
            return;
        }
        push(u, l, r);
        int m = (l + r) >> 1;
        if (ql <= m) upd(u << 1, l, m, ql, qr, v);
        if (qr > m) upd(u << 1 | 1, m + 1, r, ql, qr, v);
        s1[u] = (s1[u << 1] + s1[u << 1 | 1]) % MOD;
        s2[u] = (s2[u << 1] + s2[u << 1 | 1]) % MOD;
    }
}