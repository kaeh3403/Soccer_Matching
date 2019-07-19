<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>축구사이트</title>
    <!--Bootstrap.css-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!--JQuery.css-->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!--Bootstrap Jquery.min.js-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!--Proper.js-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <!--BootStrarp.js-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!--Google Font-->
    <link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
    <!-- JQuery UI -->
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


    <style>
        * {
            font-family: 'Jua';
        }
        
        label {
            font-size: 20px;
        }
        
        .header {
            font-size: 40px;
            font-weight: bold;
            text-align: center;
            height: 10vh;
            line-height: 10vh;
        }
        
        #section {
            height: 75vh;
        }
        
        .btn_check {
            display: inline-block;
            margin-top: 33px;
            background-color: grey;
            border: 0px;
        }
        
        #id {
            display: inline;
        }
        
        #id_check {
            margin-top: 36px;
        }
        
        #footer {
            width: 100%;
            height: 10vh;
            background-color: grey;
            line-height: 10vh;
            text-align: center;
        }
        
        #datepicker:hover {
            cursor: pointer;
        }
        
        .ui-datepicker-trigger {
            width: 35px;
            height: 35px;
            margin-left: 10px;
        }
    </style>

</head>

<body>
    <div class="container-fluid">
        <div id="header">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="header">축구사이트</div>
                </div>
                <div class="col-md-3"></div>
            </div>

            <br/>
            <br/>
            <br/>
        </div>
        <div id="section">
            <form action="main.html" class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-3">
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md">
                                    <label for="id">아이디</label>
                                    <input type="text" class="form-control" id="id" placeholder="아이디는 20자 이하" maxlength=20 required>
                                    <div class="invalid-feedback">반드시 입력하셔야 합니다.</div>
                                </div>
                                <div class="col-md">
                                    <input type="button" id="id_check" class="btn btn-primary btn_check" data-toggle="modal" data-target="#id_modal" value="중복체크">
                                    <div class="invalid-feedback">중복체크가 안되어 있습니다.</div>
                                </div>
                            </div>

                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md">
                                    <label for="password">비밀번호</label>
                                    <input type="password" class="form-control" id="password" placeholder="비밀번호" required>
                                    <div class="invalid-feedback">반드시 입력하셔야 합니다.</div>
                                </div>
                                <div class="col-md">
                                    <label for="password_check">비밀번호 확인</label>
                                    <input type="password" class="form-control" id="password_check" placeholder="비밀번호" required>
                                    <div class="invalid-feedback">반드시 입력하셔야 합니다.</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md">
                                    <label for="name">이름</label>
                                    <input type="text" class="form-control" id="name" placeholder="이름은 10자 이하" maxlength=10 required>
                                    <div class="invalid-feedback">반드시 입력하셔야 합니다.</div>
                                </div>
                                <div class="col-md">
                                    <label for="cphone">전화번호</label>
                                    <input type="text" class="form-control" id="cphone" placeholder="-없이 숫자만 입력" maxlength=13 required>
                                    <div class="invalid-feedback">반드시 입력하셔야 합니다.</div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md">
                                    <label for="birthday" style="display:block;">생년월일</label>
                                    <input type="text" class="form-control" id="birthday" placeholder="오른쪽 아이콘을 클릭하세요" style="width:80%;display:inline-block" disabled required>
                                    <div class="invalid-feedback">반드시 입력하셔야 합니다.</div>
                                </div>
                                <div class="col-md">
                                    <label for="gender">성별</label>
                                    <br/>
                                    <select id="gender" class="form-control" required>
                                        <option value="">성별을 선택해주세요</option>
                                        <option>남자</option>
                                        <option>여자</option>
                                    </select>
                                    <div class="invalid-feedback">성별을 선택해주세요</div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col-md">
                                    <label for="email">이메일</label>
                                    <input type="text" id="email" class="form-control" placeholder="1234abcd@gmail.com" required>
                                    <div class="invalid-feedback">반드시 입력하셔야 합니다.</div>
                                </div>
                                <div class="col-md"></div>
                            </div>
                        </div>

                        <br/>
                        <br/>
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6" style="margin-left:auto;margin-right:auto;">
                                <input type="submit" class="btn btn-dark" value="회원가입" style="float:left;">
                                <input type="reset" class="btn btn-dark" value="내용초기화" style="margin-left:10%;float:right;">
                            </div>
                            <div class="col-md-3"></div>
                        </div>

                    </div>
                </div>
                <div class="col-md-3"></div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <br/>
                        <br/>
                        <a href="#" data-toggle="modal" data-target="#matchModal" style="margin: auto;text-align: center;display:block;">이미 아이디가 있으시다면 여기를 클릭하세요</a>
                    </div>
                    <div class="col-md-3"></div>
                </div>
                </form>
                </div>

        <!-- 로그인 Modal -->
        <!-- The Modal -->
        <div class="modal fade" id="matchModal">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">로그인</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <form action="/action_page.php">
                            <div class="form-group">
                                <label for="id_login">ID</label>
                                <input type="email" class="form-control" id="id_login">
                            </div>
                            <div class="form-group">
                                <label for="pwd">비밀번호</label>
                                <input type="password" class="form-control" id="pwd">
                            </div>
                            <br/>
                            <button type="submit" class="btn btn-primary" style="position:relative;left:35%;background-color:rgb(89, 196, 103);">로그인</button><br/><br/>

                        </form>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="footer">
        조원 : 임홍휘, 김성규, 박상준, 김현민, 이원희
    </div>

    <!-- Id 체크 Modal -->
    <div class="modal fade" id="id_modal">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">ID 중복확인</h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="Register.js"></script>
    <script type="text/javascript" src="Datepicker.js"></script>
</body>

</html>