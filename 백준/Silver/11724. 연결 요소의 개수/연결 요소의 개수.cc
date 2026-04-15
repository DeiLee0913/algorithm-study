#include <iostream>
#include <vector>

using namespace std;

void dfs(int here, vector<vector<int>>& adjs, vector<bool>& visited) {
	visited[here] = true;

	for (int i = 0; i < adjs[here].size(); i++) {
		int there = adjs[here][i];
		if (!visited[there]) {
			dfs(there, adjs, visited);
		}
	}

	return;
}

int dfsAll(vector<vector<int>>& adjs, vector<bool>& visited) {
	int cnt = 0;

	for (int i = 1; i < visited.size(); i++) {
		if (!visited[i]) {
			cnt++;
			dfs(i, adjs, visited);
		}
	}
	
	return cnt;
}

int main() {
	cin.tie(NULL); cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> adjs(n+1);
	vector<bool> visited(n + 1, 0);

	int a, b;

	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		adjs[a].push_back(b);
		adjs[b].push_back(a);
	}

	cout << dfsAll(adjs, visited) << "\n";

	return 0;
}