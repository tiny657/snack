- login 후 원래 페이지로 redirect 하자.
- document.hbs와 documents.hbs의 공통 부분을 추출하자.

- markdown preview 동시에 보이는 모드로 변경하자.
- comment, share, keep 에서 tooltip 표시하도록 하자.
- 사진 첨부 기능 추가
- 중간에 more로 받은 것은 javascript이 동작하지 않음
- profile 사진 크기 확인 필요 (50*50)
- 로그인 안 하면 글 못 쓰게 하자.
- Document에 글 숨기기 기능 추가
- 500 error page (login 사용자 표시 필요)
- 404 error page 표시 시 css 깨지는 현상 있음
- UserConnection는 under_scope로 바뀌면 안됨.
- 한글 tab 에서 앞쪽으로 한글 넘어가는 이슈 있음
- tabindex="3" 동작 안 하는 것 수정 필요

- user profile (timeline, stackoverflow, github참고)
- user activity
- skill page
- document 수정 기능
- comment 수정 기능
- DB index 확인 (@Index 안됨)
- DB length 적절히 조절
- trend와 total skill count 표시

- UI
- comment 출력 시 markdown UI formating 수정 필요
- New Document 상단에 줄 없애기 (css: post-block)
- Post Comment 버튼 앞에 여백은 (form-group의 하단 여백 15px가 무시되어서 because theme-admin-extension.css)
- 불필요한 header 삭제
- markdown (현재 multiple line 미지원)

- 운영
- skill 분류: (advanced, normal) or (mandatory, optional)

- 나중
- skill별 unsubscribe
- popular : 인기있는 글만 보기
