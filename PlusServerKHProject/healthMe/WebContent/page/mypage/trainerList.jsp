<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <!--인코딩 문자셋-->
    <meta charset="UTF-8">
    <!--반응형 웹을 만들기 위한 meta태그의 viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--페이지 설명-->
    <meta name="subject" content="헬th미 Q&APage" />
    <!--키워드-->
    <meta name="keywords" content="www.healthme.com, 트레이너, 나만의, 맞춤" />
    <!--스타일-->
    <link rel="stylesheet" href="../css/trainerList/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/myPage/checkandcancel.js"></script>
    <link rel="stylesheet" href="../../css/mypage/trainerList.css" />
    
    <!--title-->
    <title>헬th미:나만의 트레이너</title>

</head>

<body>



    <!--전체 공간-->
    <div id="wrapper">
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
            <div id="mobileMenu">
                핸드폰일 경우 메뉴
            </div>
            <div id="logo">
                <img src="../../img/%EB%A1%9C%EA%B3%A0.png">
            </div>
            <div id="searchBar">
                <input type="text" name="searchInput" id="searchInput" value="지역, 종목 검색" />
            </div>
            <div id="menu">
                로그인, 메뉴
            </div>
        </div>

        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                    <div id="titleSpace">
                        <span id="title">Trainer-list</span>
                    </div>

                    <div id="trainerSpace">
                        <table id="tblMember">
                            <colgroup>
                                <col style="width:17%">
                                <col style="width:8%">
                                <col style="width:8%">
                                <col style="width:8%">
                                <col style="width:*%">
                                <col style="width:8%">
                                <col style="width:8%">
                            </colgroup>
                            <thead>
                                <tr id="trainerSpaceSubTitle">
                                    <th scope="col">강사</th>
                                    <th scope="col">이름</th>
                                    <th scope="col">지역</th>
                                    <th scope="col">종목</th>
                                    <th scope="col">소개</th>
                                    <th scope="col">체크</th>
                                    <th scope="col">버튼</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="line">
                                    <!--a href="#"-->
                                    <td><img src="../../img/jubin.jpg"></td>
                                    <td>이주빈</td>
                                    <td>강남</td>
                                    <td>요가</td>
                                    <td>Wanna be a supermodel?</td>
                                    <td><input type="checkbox" name="pid" id="check"></td>
                                    <td><input type="submit" value="컨택하기">
                                        <!--a href="#">-CLEAR-</a></td-->
                                </tr>
                                <tr class="line">
                                    <td><img src="../../img/jaehun.jpg"></td>
                                    <td>이제훈</td>
                                    <td>강서</td>
                                    <td>PersonalTraining</td>
                                    <td> "3주만에 눈에 보이는 체중감량!"</td>
                                    <td><input type="checkbox" name="pid" id="check"></td>
                                    <td><input type="submit" value="컨택하기">
                                        <!--a href="#">-CLEAR-</a></td-->
                                </tr>
                                <tr class="line">
                                    <td><img src="../../img/seolhyun.jpg"></td>
                                    <td>김설현</td>
                                    <td>강북</td>
                                    <td>수영</td>
                                    <td>"어제 먹은 고기를 불태우자!"</td>
                                    <td><input type="checkbox" name="pid" id="check"></td>
                                    <td><input type="submit" value="컨택하기">
                                        <!--a href="#">-CLEAR-</a></td-->
                                </tr>

                                <tr class="line">
                                    <td><img src="../../img/jongkyu.png"></td>
                                    <td>M-Dragon</td>
                                    <td>금천구</td>
                                    <td>역도</td>
                                    <td>MuscleDragon의 강력한 역도<br>- (용상과 인상)</td>
                                    <td><input type="checkbox" name="pid" id="check"></td>
                                    <td><input type="submit" value="컨택하기">
                                        <!--a href="#">-CLEAR-</a></td-->
                                </tr>

                                <tr class="line">
                                    <td><img src="../../img/yeonggi.png"></td>
                                    <td>yeonggi</td>
                                    <td>멜버른</td>
                                    <td>외국어</td>
                                    <td>캥거루언어 10주 완벽정복</td>
                                    <td><input type="checkbox" name="pid" id="check"></td>
                                    <td><input type="submit" value="컨택하기">
                                        <!--a href="#">-CLEAR-</a></td-->
                                </tr>

                                <tr class="line">
                                    <td><img src="../../img/laewon.jpg"></td>
                                    <td>김래원</td>
                                    <td>강서</td>
                                    <td>연기</td>
                                    <td>연기의 기본은 표정연기</td>
                                    <td><input type="checkbox" name="pid" id="check"></td>
                                    <td><input type="submit" value="컨택하기">
                                        <!--a href="#">-CLEAR-</a></td-->
                                </tr>
                                <tr class="line">
                                    <td><img src="../../img/yuna.jpg"></td>
                                    <td>김연아</td>
                                    <td>군포</td>
                                    <td>피겨</td>
                                    <td>월드챔피언의 특별강습</td>
                                    <td><input type="checkbox" name="pid" id="check"></td>
                                    <td><input type="submit" value="컨택하기">
                                        <!--a href="#">-CLEAR-</a></td-->
                                </tr>

                            </tbody>
                        </table>
                    </div>
                    <center>
                    <div id="trainerBtnSpace">
                        <input type="button" class="btn btn-warning" id="chkObj" onclick="check1Btn();" value="전체선택" />
                        <input type="button" class="btn btn-warning" id="chkObj" onclick="check2Btn();" value="전체취소" />
                        <input type="button" class="btn btn-warning" id="btnDelete" name="btnDelete" value="선택삭제" onclick="btnDelete()" />


                        <a href="" class="btn btn-warning"> - Roll Back - </a>

                    </div>
					</center>


                </div>
            </div>
        </div>

        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">
            김구이김주정조 정보
        </div>
    </div>

</body>

</html>