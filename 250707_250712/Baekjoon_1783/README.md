<div class="row">
		<div class="col-md-12">
			<div id="result_log"></div>
		</div>
		<div class="col-md-12">
							<ul class="nav nav-pills no-print problem-menu"><li class="active">
		<a href="/problem/1783"><img src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg" class="solvedac-tier">&nbsp;1783번</a>
</li><li><a href="/submit/1783">제출</a></li><li><a href="/problem/status/1783">맞힌 사람</a></li><li><a href="/short/status/1783">숏코딩</a></li><li><a href="/problem/history/1783">재채점 결과</a></li><li><a href="/status?from_problem=1&amp;problem_id=1783">채점 현황</a></li><li><a href="/status?from_mine=1&amp;problem_id=1783&amp;user_id=joyeun00">내 제출</a></li><li class="dropdown"><a class="dropdown-toggle" id="drop5" role="button" data-toggle="dropdown" href="#">강의<b class="caret"></b></a><ul id="menu2" class="dropdown-menu" role="menu" aria-labelledby="drop5"><li><a tabindex="-1" href="https://code.plus/course/43">알고리즘 중급 1/3</a></li></ul></li><li><a href="/board/search/all/problem/1783">질문 게시판</a></li></ul>
					</div>
		<div class="col-md-12">
			<div class="page-header">
				<h1><span class="printable">
	1783번
 - </span><span id="problem_title">병든 나이트</span>
								<div class="btn-group pull-right problem-button">
																										<button class="btn btn-default" type="button" id="favorite_button" data-favorite="0"><span class="glyphicon glyphicon-star-empty" id="favorite_image"></span></button>
																																						</div>
				</h1>
									
							</div>
		</div>
		<div class="col-md-12"><div class="table-responsive"><table class="table" id="problem-info"><thead><tr><th style="width:16%;">시간 제한</th><th style="width:16%;">메모리 제한</th><th style="width:17%;">제출</th><th style="width:17%;">정답</th><th style="width:17%;">맞힌 사람</th><th style="width:17%;">정답 비율</th></tr></thead><tbody><tr><td>2 초 </td><td>128 MB</td><td>17976</td><td>7921</td><td>6735</td><td>43.959%</td></tr></tbody></table></div></div>
						<div id="problem-body" class="">
			<div class="col-md-12">
				<section id="description" class="problem-section">
				<div class="headline">
				<h2>문제</h2>
				</div>
				<div id="problem_description" class="problem-text">
				<p>병든 나이트가 N ×&nbsp;M 크기 체스판의 가장 왼쪽아래 칸에 위치해 있다. 병든 나이트는 건강한 보통 체스의 나이트와 다르게 4가지로만 움직일 수 있다.</p>

<ol>
	<li>2칸 위로, 1칸 오른쪽</li>
	<li>1칸 위로, 2칸 오른쪽</li>
	<li>1칸 아래로, 2칸 오른쪽</li>
	<li>2칸 아래로, 1칸 오른쪽</li>
</ol>

<p>병든 나이트는 여행을 시작하려고 하고, 여행을 하면서 방문한 칸의 수를 최대로 하려고 한다.&nbsp;병든 나이트의 이동 횟수가 4번보다 적지 않다면,&nbsp;이동 방법을 모두 한 번씩 사용해야&nbsp;한다. 이동 횟수가 4번보다 적은 경우(방문한 칸이 5개 미만)에는 이동 방법에 대한 제약이 없다.</p>

<p>체스판의 크기가 주어졌을 때, 병든 나이트가 여행에서 방문할 수 있는 칸의 최대 개수를 구해보자.</p>

				</div>
				</section>
			</div>
										<div class="col-md-12">
					<section id="input" class="problem-section">
					<div class="headline">
					<h2>입력</h2>
					</div>
					<div id="problem_input" class="problem-text">
					<p>첫째 줄에 체스판의 세로 길이 N와 가로 길이 M이 주어진다. N과 M은 2,000,000,000보다 작거나 같은 자연수이다.</p>

					</div>
					</section>
				</div>
	
				<div class="col-md-12">
					<section id="output" class="problem-section">
					<div class="headline">
					<h2>출력</h2>
					</div>
					<div id="problem_output" class="problem-text">
					<p>병든 나이트가 여행에서 방문할 수 있는 칸의 개수중 최댓값을 출력한다.</p>

					</div>
					</section>
				</div>
						<div class="col-md-12">
			<section id="limit" style="display:none;" class="problem-section">
			<div class="headline">
			<h2>제한</h2>
			</div>
			<div id="problem_limit" class="problem-text">
						</div>
			</section>
			</div>
																	<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<section id="sampleinput1">
						<div class="headline">
						<h2>예제 입력 1
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-1">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-input-1">100 50
</pre>
						</section>
					</div>
					<div class="col-md-6">
						<section id="sampleoutput1">
						<div class="headline">
						<h2>예제 출력 1
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-1">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-output-1">48
</pre>
						</section>
					</div>
									</div>
				</div>
								<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<section id="sampleinput2">
						<div class="headline">
						<h2>예제 입력 2
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-2">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-input-2">1 1
</pre>
						</section>
					</div>
					<div class="col-md-6">
						<section id="sampleoutput2">
						<div class="headline">
						<h2>예제 출력 2
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-2">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-output-2">1
</pre>
						</section>
					</div>
									</div>
				</div>
								<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<section id="sampleinput3">
						<div class="headline">
						<h2>예제 입력 3
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-3">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-input-3">17 5
</pre>
						</section>
					</div>
					<div class="col-md-6">
						<section id="sampleoutput3">
						<div class="headline">
						<h2>예제 출력 3
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-3">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-output-3">4
</pre>
						</section>
					</div>
									</div>
				</div>
								<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<section id="sampleinput4">
						<div class="headline">
						<h2>예제 입력 4
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-4">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-input-4">2 4
</pre>
						</section>
					</div>
					<div class="col-md-6">
						<section id="sampleoutput4">
						<div class="headline">
						<h2>예제 출력 4
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-4">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-output-4">2
</pre>
						</section>
					</div>
									</div>
				</div>
								<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<section id="sampleinput5">
						<div class="headline">
						<h2>예제 입력 5
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-input-5">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-input-5">20 4
</pre>
						</section>
					</div>
					<div class="col-md-6">
						<section id="sampleoutput5">
						<div class="headline">
						<h2>예제 출력 5
							<button type="button" class="btn btn-link copy-button" style="padding: 0px;" data-clipboard-target="#sample-output-5">복사</button>
						</h2>
						</div>
						<pre class="sampledata" id="sample-output-5">4
</pre>
						</section>
					</div>
									</div>
				</div>
										<div class="col-md-12">
				<section id="hint" style="display: none;" class="problem-section">
				<div class="headline">
				<h2>힌트</h2>
				</div>
				<div id="problem_hint" class="problem-text">
				
				</div>
				</section>
			</div>
								</div>
									<div class="col-md-12"><section id="source"><div class="headline"><h2>출처</h2></div><ul><li>문제를 번역한 사람:&nbsp;<a href="/user/baekjoon">baekjoon</a></li><li>문제의 오타를 찾은 사람:&nbsp;<a href="/user/gudori888">gudori888</a>, <a href="/user/han1g">han1g</a>, <a href="/user/jh05013">jh05013</a>, <a href="/user/luluctrl4">luluctrl4</a>, <a href="/user/shnoh">shnoh</a></li></ul></section></div>
													<div class="col-md-12">
					<section id="problem_tags">
					<div class="headline">
					<h2>알고리즘 분류</h2>
					</div>
																															<div class="problem-text"><p><a href="#" class="show-spoiler">보기</a></p></div>
					<div class="spoiler" style="display:none;">
  					<ul class="spoiler-list">
  						  							<li>
  							<a href="/problem/tag/102" class="spoiler-link">구현</a>
  							</li>
  						  							<li>
  							<a href="/problem/tag/33" class="spoiler-link">그리디 알고리즘</a>
  							</li>
  						  							<li>
  							<a href="/problem/tag/137" class="spoiler-link">많은 조건 분기</a>
  							</li>
  						  					</ul>
					</div>
										</section>
				</div>
																						<div class="col-md-12">
					<section id="problem_memo">
					<div class="headline">
					<h2>메모</h2>
					</div>
						<div id="problem-memo-view" class="problem-text">
			</div>
	<div id="problem-memo-edit" style="display: none;"><textarea name="memo-content" id="memo-content" class="form-control" style="display:none;"></textarea><div class="editor-toolbar"><a title="Bold (Ctrl-B)" tabindex="-1" class="fa fa-bold"></a><a title="Italic (Ctrl-I)" tabindex="-1" class="fa fa-italic"></a><a title="Heading (Ctrl-H)" tabindex="-1" class="fa fa-header"></a><a title="Big Heading" tabindex="-1" class="fa fa-header fa-header-x fa-header-1"></a><a title="Medium Heading" tabindex="-1" class="fa fa-header fa-header-x fa-header-2"></a><a title="Small Heading" tabindex="-1" class="fa fa-header fa-header-x fa-header-3"></a><i class="separator">|</i><a title="Code (Ctrl-Alt-C)" tabindex="-1" class="fa fa-code"></a><a title="Quote (Ctrl-')" tabindex="-1" class="fa fa-quote-left"></a><a title="Generic List (Ctrl-L)" tabindex="-1" class="fa fa-list-ul"></a><a title="Numbered List (Ctrl-Alt-L)" tabindex="-1" class="fa fa-list-ol"></a><a title="Insert Horizontal Line" tabindex="-1" class="fa fa-minus"></a><i class="separator">|</i><a title="Create Link (Ctrl-K)" tabindex="-1" class="fa fa-link"></a><a title="Insert Image (Ctrl-Alt-I)" tabindex="-1" class="fa fa-picture-o"></a><i class="separator">|</i><a title="Toggle Preview (Ctrl-P)" tabindex="-1" class="fa fa-eye no-disable"></a><a title="Toggle Side by Side (F9)" tabindex="-1" class="fa fa-columns no-disable no-mobile"></a><a title="Toggle Fullscreen (F11)" tabindex="-1" class="fa fa-arrows-alt no-disable no-mobile"></a></div><div class="CodeMirror cm-s-paper CodeMirror-wrap"><div style="overflow: hidden; position: relative; width: 3px; height: 0px;"><textarea autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0" style="position: absolute; padding: 0px; width: 1000px; height: 1em; outline: none;"></textarea></div><div class="CodeMirror-vscrollbar" cm-not-content="true"><div style="min-width: 1px;"></div></div><div class="CodeMirror-hscrollbar" cm-not-content="true"><div style="height: 100%; min-height: 1px;"></div></div><div class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler" cm-not-content="true"></div><div class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer" style="margin-left: 0px;"><div style="position: relative;"><div class="CodeMirror-lines"><div style="position: relative; outline: none;"><div class="CodeMirror-measure"><pre><span>xxxxxxxxxx</span></pre></div><div class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div class="CodeMirror-cursors"></div><div class="CodeMirror-code"></div></div></div></div></div><div style="position: absolute; height: 30px; width: 1px;"></div><div class="CodeMirror-gutters" style="display: none;"></div></div></div><div class="editor-preview-side"></div><div class="editor-statusbar"><span class="autosave"></span><span class="lines">1</span><span class="words">0</span><span class="cursor">0:0</span></div></div><p class="lead text-center no-print" id="problem-memo-button"><a href="#" class="problem-memo-write">메모 작성하기</a></p><p class="lead text-center no-print" id="problem-memo-save-div" style="display: none;"><button type="button" class="btn btn-primary btn-lg" id="problem-memo-save" data-loading-text="작성 중...">저장</button>&nbsp;<button type="button" class="btn btn-lg" id="problem-memo-cancel">취소</button></p>

					</section>
				</div>
						</div>
