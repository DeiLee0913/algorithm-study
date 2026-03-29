#include <iostream>
#include <queue>

using namespace std;

int main() {
	queue<int> cards;

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cards.push(i);
	}
	
	while(cards.size() >= 2) {
		// 제일 위에 있는 카드를 바닥에 버리고
		cards.pop();
		// 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
		cards.push(cards.front());
		cards.pop();
	}

	cout << cards.front();

	return 0;
}