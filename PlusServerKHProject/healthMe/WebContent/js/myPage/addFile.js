function addLicense() {
	fileCnt = document.getElementById('fileCnt').value;
	if (fileCnt == 5) {
		alert("그정도면 충분한것 같아요");
		return false;
	} else {
		fileCnt++;
	}
	html = '';
	html += '<input id="licenseName'
			+ fileCnt
			+ '" name="licenseName'
			+ fileCnt
			+ '" type="text" placeholder="예) GTQ 1급, 입상경력.." value="" class="input_txt01 clearbt"/> <br>';

	var div = document.createElement('div');
	div.innerHTML = html;
	document.getElementById('CertAdd').appendChild(div);
	document.getElementById('fileCnt').value = fileCnt;
}

function addCareer() {
	careerfileCnt = document.getElementById('careerfileCnt').value;
	if (careerfileCnt == 5) {
		alert("그정도면 충분한것 같아요");
		return false;
	} else {
		careerfileCnt++;
	}
	html = '';
	html += '<input id="careerName' + careerfileCnt + '" name="careerName'
			+ careerfileCnt
			+ '" type="text" placeholder="ex)고라니GYM 근무" value="" />';
	html += '<input type="date" id="careerStart' + careerfileCnt
			+ '" name="careerStart' + careerfileCnt
			+ '" value="2015-10-10" min="1990-01-01" max="2018-12-31"/> ~ ';
	html += '<input type="date" id="careerEnd' + careerfileCnt
			+ '" name="careerEnd' + careerfileCnt
			+ '" value="2015-10-10" min="1990-01-01" max="2018-12-31"/>';
	html += '<input type="submit" value="전송">';

	var div = document.createElement('div');
	div.innerHTML = html;
	document.getElementById("CertCareer").appendChild(div);
	document.getElementById('careerfileCnt').value = careerfileCnt;
}