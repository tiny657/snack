- header가 없는 것으로 변경 필요
- 500 error page
- UserConnection는 under_scope로 바뀌면 안됨.
- 한글 tab 에서 앞쪽으로 한글 넘어가는 이슈 있음
- tabindex="3" 동작 안 하는 것 수정 필요
- header.hbs에 메뉴 분리
- More 기능 추가
- 로그인 안 하면 글 못 쓰게 하자.
- imageUrl도 profile에 추가하자.

- user profile (timeline, stackoverflow, github참고)
- user activity
- skill page
- document 수정 기능
- comment 수정 기능
- DB index 확인 (@Index 안됨)
- DB length 적절히 조절
- trend와 total skill count 표시

- UI
- New Document 상단에 줄 없애기 (css: post-block)
- Post Comment 버튼 앞에 여백은 (form-group의 하단 여백 15px가 무시되어서 because theme-admin-extension.css)
- header 삭제 (로그인 추가)
- markdown (현재 multiple line 미지원)

- 운영
- skill 분류: (advanced, normal) or (mandatory, optional)

- 나중
- skill별 unsubscribe
- popular : 인기있는 글만 보기
