
function stipendValidate(){
	
	if(stipendForm.name.value==""){
		//alert("����дԱ��������");		
		stipendForm.name.focus();
		return false;
	}
	if(stipendForm.basic.value==""){
		//alert("����д����н��");		
		stipendForm.basic.focus();
		return false;
	}
	if(stipendForm.eat.value==""){
		//alert("����дԱ��������");	
		alert("饭补不能为空")	
		stipendForm.eat.focus();
		return false;
	}
	if(stipendForm.granttime.value==""){
		//alert("����д����ʱ�䣡");		
		stipendForm.granttime.focus();
		return false;
	}
	if(!checkIsValidDate(stipendForm.granttime.value)){
		//alert("�����ʱ�䲻�Ϸ�������-��-�գ�");
		stipendForm.granttime.focus();
		return false;
	}

	return true;
}
function institutionValidate(){
	if(institutionForm.name.value==""){
		//alert("����д�������ƣ�");		
		institutionForm.name.focus();
		return false;
	}
	if(institutionForm.reason.value==""){
		//alert("����д����ԭ��");		
		institutionForm.reason.focus();
		return false;
	}
	return true;
}
function userValidate(){
	if(userForm.username.value==""){
		//alert("����д��Ա������");		
		userForm.username.focus();
		return false;
	}
	if(userForm.password.value==""){
		//alert("����д��½���룡");		
		userForm.password.focus();
		return false;
	}
	if(userForm.birthday.value==""){
		//alert("����д�������ڣ�");		
		userForm.birthday.focus();
		return false;
	}
	if(CheckDate(userForm.birthday.value)){
		//alert("��������ڲ��Ϸ�������-��-�գ�");
		userForm.birthday.focus();
		return false;
	}
	return true;
}

function educateValidate(){
	if(educateForm.name.value==""){
		//alert("����д��ѵ���ƣ�");		
		educateForm.name.focus();
		return false;
	}
	if(educateForm.purpose.value==""){
		//alert("����д��ѵĿ�ģ�");		
		educateForm.purpose.focus();
		return false;
	}
	if(educateForm.begintime.value==""){
		//alert("����д��ѵ��ʼʱ�䣡");		
		educateForm.begintime.focus();
		return false;
	}
	if(!checkIsValidDate(educateForm.begintime.value)){
		alert(educateForm.begintime.value);
		educateForm.begintime.focus();
		return false;
	}

	if(educateForm.endtime.value==""){
		//alert("����д��ѵ����ʱ�䣡");		
		educateForm.endtime.focus();
		return false;
	}
	if(!checkIsValidDate(educateForm.endtime.value)){
		alert(educateForm.endtime.value);
		educateForm.endtime.focus();
		return false;
	}
	if(!checkDateEarlier(educateForm.begintime.value,educateForm.endtime.value)){
		//alert("��ʼ���ڲ������ڽ������ڣ�");
		educateForm.begintime.focus();
		return false;
	}

	if(educateForm.teacher.value==""){
		//alert("����д��ѵ��ʦ��");		
		educateForm.teacher.focus();
		return false;
	}
	if(educateForm.student.value==""){
		//alert("����д��ѵ��Ա��");		
		educateForm.student.focus();
		return false;
	}
	return true;
}

function checkDateEarlier(strStart,strEnd)
{
    if(checkIsValidDate(strStart) == false || checkIsValidDate(strEnd) == false)
        return false;
    //�����һ������Ϊ�գ���ͨ������
    if (( strStart == "" ) || ( strEnd == "" ))
        return true;
    var arr1 = strStart.split("-");
    var arr2 = strEnd.split("-");
    var date1 = new Date(arr1[0],parseInt(arr1[1].replace(/^0/,""),10) - 1,arr1[2]);
    var date2 = new Date(arr2[0],parseInt(arr2[1].replace(/^0/,""),10) - 1,arr2[2]);
    if(arr1[1].length == 1)
        arr1[1] = "0" + arr1[1];
    if(arr1[2].length == 1)
        arr1[2] = "0" + arr1[2];
    if(arr2[1].length == 1)
        arr2[1] = "0" + arr2[1];
    if(arr2[2].length == 1)
        arr2[2]="0" + arr2[2];
    var d1 = arr1[0] + arr1[1] + arr1[2];
    var d2 = arr2[0] + arr2[1] + arr2[2];
    if(parseInt(d1,10) > parseInt(d2,10))
       return false;
    else
       return true;
}//~~~
function checkIsValidDate(str)
{    
     //alert(str);  
    //���Ϊ�գ���ͨ��У��
    if(str == "")
        return true;
    var pattern = /^((\d{4})|(\d{2}))-(\d{1,2})-(\d{1,2})$/g;
    if(!pattern.test(str)){
        return false;
	}
    var arrDate = str.split("-");
    ////alert(arrDate[0])
    ////alert(arrDate[1])
    ////alert(arrDate[2])
    
    var date =  new Date(arrDate[0],arrDate[1] ,arrDate[2]);
    
    
    
    
//    if(date.getYear() == parseInt(arrDate[0],10)
//       && date.getMonth() == parseInt(arrDate[1],10)
//       && date.getDate() == parseInt(arrDate[2],10)){
//	
//        return true;
//	}else{
//       return false;
//	}
return true;
}//~~~

function CheckDate(INDate)
{ if (INDate=="")
    {return true;}
	subYY=INDate.substr(0,4)
	if(isNaN(subYY) || subYY<=0){
		return true;
	}
	//ת���·�
	if(INDate.indexOf('-',0)!=-1){	separate="-"}
	else{
		if(INDate.indexOf('/',0)!=-1){separate="/"}
		else {return true;}
		}
		area=INDate.indexOf(separate,0)
		subMM=INDate.substr(area+1,INDate.indexOf(separate,area+1)-(area+1))
		if(isNaN(subMM) || subMM<=0){
		return true;
	}
		if(subMM.length<2){subMM="0"+subMM}
	//ת����
	area=INDate.lastIndexOf(separate)
	subDD=INDate.substr(area+1,INDate.length-area-1)
	if(isNaN(subDD) || subDD<=0){
		return true;
	}
	if(eval(subDD)<10){subDD="0"+eval(subDD)}
	NewDate=subYY+"-"+subMM+"-"+subDD
	if(NewDate.length!=10){return true;}
    if(NewDate.substr(4,1)!="-"){return true;}
    if(NewDate.substr(7,1)!="-"){return true;}
	var MM=NewDate.substr(5,2);
	var DD=NewDate.substr(8,2);
	if((subYY%4==0 && subYY%100!=0)||subYY%400==0){ //�ж��Ƿ�Ϊ����
		if(parseInt(MM)==2){
			if(DD>29){return true;}
		}
	}else{
		if(parseInt(MM)==2){
			if(DD>28){return true;}
		}	
	}
	var mm=new Array(1,3,5,7,8,10,12); //�ж�ÿ���е��������
	for(i=0;i< mm.length;i++){
		if (parseInt(MM) == mm[i]){
			if(parseInt(DD)>31){return true;}
		}else{
			if(parseInt(DD)>30){return true;}
		}
	}
	if(parseInt(MM)>12){return true;}
   return false;
  }
function jobValidate(){

	if(jobForm.name.value==""){
		//alert("����д������");		
		jobForm.name.focus();
		return false;
	}
	if(jobForm.job.value==""){
		//alert("����дְλ��");		
		jobForm.job.focus();
		return false;
	}
	if(jobForm.specialty.value==""){
		//alert("����д��ѧרҵ��");		
		jobForm.specialty.focus();
		return false;
	}
	if(jobForm.experience.value==""){
		//alert("����д�������飡");		
		jobForm.experience.focus();
		return false;
	}
	if(jobForm.studyeffort.value==""){
		//alert("����дѧ����");		
		jobForm.studyeffort.focus();
		return false;
	}
	if(jobForm.school.value==""){
		//alert("����д��ҵѧУ��");		
		jobForm.school.focus();
		return false;
	}
	if(jobForm.tel.value==""){
		//alert("����д�绰��");		
		jobForm.tel.focus();
		return false;
	}
	if(jobForm.email.value==""){
		//alert("����дEmail��");		
		jobForm.email.focus();
		return false;
	}
	return true;
}
function adminChecked(){
	if(userForm.isadminhelp.checked){
		document.userForm.isadmin.value="1";
	}else{
		document.userForm.isadmin.value="0";
	}
}
