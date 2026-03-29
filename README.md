# algorithm-study

알고리즘을 공부하면서 푼 **PS(Problem Solving)** 코드를 모아 두는 저장소입니다. 주로 백준 문제를 풀이합니다. 정답으로 인정된 코드만 업로드합니다.

## 구조

문제는 **유형·주제**별로 나누어 두었습니다.

```
백준/
├── stack/           # 스택·모노톤 스택 등
├── queue/           # 큐·덱 활용
├── sorting/
├── implementation/  # 시뮬레이션·단순 구현 위주
├── io/              # 입력 규모·형식이 핵심인 문제
├── math/
└── solved/          # BaekjoonHub가 여기로 먼저 올림 → 아래 주제 폴더로 `git mv`로 정리
```

문제마다 `문제번호. 제목` 폴더 안에 제출 소스와 BaekjoonHub가 만든 `README.md`(문제 링크, 태그, 성능, 제출 일자 등)가 함께 있습니다.

## BaekjoonHub (`백준/solved/`)

로컬에 커스텀한 [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub) 확장을 쓰면, 맞았을 때 **`백준/solved/문제번호. 제목/`** 경로로 푸시되도록 바꿔 두었습니다. 난이도 폴더(`Bronze` / `Silver` / `Gold`)는 쓰지 않습니다.

그 다음 **주제별 폴더**(`stack`, `queue`, …)로 옮기고 싶을 때는 `git mv`로 옮기면 됩니다. 히스토리를 유지하려면 폴더 통째로 이동하면 됩니다.

공식 스토어 확장은 기본이 난이도 경로이므로, 이 리포와 맞추려면 **소스 클론 → 수정 → 압축 해제 로드** 방식을 쓰면 됩니다. ([커스터마이징 예시](https://www.jubinpark.com/2024/02/leethub-baekjoonhub.html))

## 사용 언어

대부분 **Java**로 제출하고, 일부 문제는 **C++** 등 다른 언어로도 풀이가 있을 수 있습니다.

## 참고

- [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub) — 백준 ↔ GitHub 연동 확장 프로그램
