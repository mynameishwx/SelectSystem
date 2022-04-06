
function starttwo(hh,sex){
	 switch(hh){
		 case 1:document.getElementById("school1").click=selectone(sex); break;
		 case 2:document.getElementById("school2").click=selecttwo(sex); break;
		 case 3:document.getElementById("school3").click=selectthree(sex); break;
		 case 4:document.getElementById("school4").click=selectfour(sex); break;
		 case 5:document.getElementById("school5").click=selectfive(sex); break;
	 }
  }
  // 第一个列表---------------------------------------------------------------------------
  function  selectone(hh){
			  var  school1=document.getElementById("school1").value;
			  if(school1!="请选择学校"){
				 
			  }else{
				  $.ajax({
					  url:"/school/SchoolSelect",
					  type:"post",
					  success: function(data){
						  $("#school1").empty();
						  data.forEach(function(item,index){
							  $("#school1").append("<option onclick='"+"selectone1("+hh+")'>"+item+"</option>");
						  });
						  
					  }
				  });
			  }
		  }
  function  selectone1(hh){
			 var  school1=document.getElementById("school1").value;
			 var  specialty=document.getElementById("specialty").value;
			 if(school1!="请选择学校"){
				 if(specialty=="请选择专业"){
					 $.ajax({
					 		 url:"/volunteer/target",
							 type:"post",
					 		 data:{schoolname: school1,specialtyClass: hh},
					 		 success: function(twodata){
					 			 $("#specialty").empty();
					 			 twodata.forEach(function(i,t){
					 				 $("#specialty").append("<option>"+i+"</option>");
					 			 });
					 		 }
					 });
				 }
				 else{
				 					 $.ajax({
				 						 url:"/volunteer/target",
										 type:"post",
				 						 data:{schoolname: school1,specialtyClass: hh},
				 						 success: function(twodata){
				 							 $("#specialty").empty();
				 							 twodata.forEach(function(i,t){
				 								 $("#specialty").append("<option>"+i+"</option>");
				 							 });
				 						 }
				 					 });
				 }
			 }else{
				 alert("请先选择学校");
			 }
		  }
		  
 // 第二个列表---------------------------------------------------------------------------
 // -----------------------------------------------------------------------------------
  function  selecttwo(hh){
		  			  var  school2=document.getElementById("school2").value;
		  			  if(school2!="请选择学校"){
		  				 
		  			  }else{
		  				  $.ajax({
		  					  url:"/school/SchoolSelect",
		  					  type:"post",
		  					  success: function(data){
		  						  $("#school2").empty();
		  						  data.forEach(function(item,index){
									  $("#school2").append("<option onclick='"+"selecttwo1("+hh+")'>"+item+"</option>");
		  						  });
		  						  
		  					  }
		  				  });
		  			  }
		  }
  function  selecttwo1(hh){
		  			 var  school2=document.getElementById("school2").value;
		  			 var  specialty2=document.getElementById("specialty2").value;
		  			 if(school2!="请选择学校"){
		  				 if(specialty2=="请选择专业"){
		  					 $.ajax({
		  					 		 url:"/volunteer/target",
		  							 type:"post",
		  					 		 data:{schoolname: school2,specialtyClass: hh},
		  					 		 success: function(twodata){
		  					 			 $("#specialty2").empty();
		  					 			 twodata.forEach(function(i,t){
		  					 				 $("#specialty2").append("<option>"+i+"</option>");
		  					 			 });
		  					 		 }
		  					 });
		  				 }
		  				 else{
		  				 					 $.ajax({
		  				 						 url:"/volunteer/target",
		  										 type:"post",
		  				 						 data:{schoolname: school2,specialtyClass: hh},
		  				 						 success: function(twodata){
		  				 							 $("#specialty2").empty();
		  				 							 twodata.forEach(function(i,t){
		  				 								 $("#specialty2").append("<option>"+i+"</option>");
		  				 							 });
		  				 						 }
		  				 					 });
		  				 }
		  			 }else{
		  				 alert("请先选择学校");
		  			 }
		  }
// 第三个列表
 function  selectthree(hh){
		  			  var  school3=document.getElementById("school3").value;
		  			  if(school3!="请选择学校"){
		  				 
		  			  }else{
		  				  $.ajax({
		  					  url:"/school/SchoolSelect",
		  					  type:"post",
		  					  success: function(data){
		  						  $("#school3").empty();
		  						  data.forEach(function(item,index){
									  $("#school3").append("<option onclick='"+"selectthree1("+hh+")'>"+item+"</option>");
		  						  });
		  						  
		  					  }
		  				  });
		  			  }
		  }
  function  selectthree1(hh){
		  			 var  school3=document.getElementById("school3").value;
		  			 var  specialty3=document.getElementById("specialty3").value;
		  			 if(school3!="请选择学校"){
		  				 if(specialty3=="请选择专业"){
		  					 $.ajax({
		  					 		 url:"/volunteer/target",
		  							 type:"post",
		  					 		 data:{schoolname: school3,specialtyClass: hh},
		  					 		 success: function(twodata){
		  					 			 $("#specialty3").empty();
		  					 			 twodata.forEach(function(i,t){
		  					 				 $("#specialty3").append("<option>"+i+"</option>");
		  					 			 });
		  					 		 }
		  					 });
		  				 }
		  				 else{
		  				 					 $.ajax({
		  				 						 url:"/volunteer/target",
		  										 type:"post",
		  				 						 data:{schoolname: school3,specialtyClass: hh},
		  				 						 success: function(twodata){
		  				 							 $("#specialty3").empty();
		  				 							 twodata.forEach(function(i,t){
		  				 								 $("#specialty3").append("<option>"+i+"</option>");
		  				 							 });
		  				 						 }
		  				 					 });
		  				 }
		  			 }else{
		  				 alert("请先选择学校");
		  			 }
		  }
		  
 // 第四个列表
function  selectfour(hh){
		  			  var  school4=document.getElementById("school4").value;
		  			  if(school4!="请选择学校"){
		  				 
		  			  }else{
		  				  $.ajax({
		  					  url:"/school/SchoolSelect",
		  					  type:"post",
		  					  success: function(data){
		  						  $("#school4").empty();
		  						  data.forEach(function(item,index){
									  $("#school4").append("<option onclick='"+"selectfour1("+hh+")'>"+item+"</option>");
		  						  });
		  						  
		  					  }
		  				  });
		  			  }
		  }
  function  selectfour1(hh){
		  			 var  school4=document.getElementById("school4").value;
		  			 var  specialty4=document.getElementById("specialty4").value;
		  			 if(school4!="请选择学校"){
		  				 if(specialty4=="请选择专业"){
		  					 $.ajax({
		  					 		 url:"/volunteer/target",
		  							 type:"post",
		  					 		 data:{schoolname: school4,specialtyClass: hh},
		  					 		 success: function(twodata){
		  					 			 $("#specialty4").empty();
		  					 			 twodata.forEach(function(i,t){
		  					 				 $("#specialty4").append("<option>"+i+"</option>");
		  					 			 });
		  					 		 }
		  					 });
		  				 }
		  				 else{
		  				 					 $.ajax({
		  				 						 url:"/volunteer/target",
		  										 type:"post",
		  				 						 data:{schoolname: school4,specialtyClass: hh},
		  				 						 success: function(twodata){
		  				 							 $("#specialty4").empty();
		  				 							 twodata.forEach(function(i,t){
		  				 								 $("#specialty4").append("<option>"+i+"</option>");
		  				 							 });
		  				 						 }
		  				 					 });
		  				 }
		  			 }else{
		  				 alert("请先选择学校");
		  			 }
		  }
// 第五个列表
function  selectfive(hh){
		  			  var  school5=document.getElementById("school5").value;
		  			  if(school5!="请选择学校"){
		  				 
		  			  }else{
		  				  $.ajax({
		  					  url:"/school/SchoolSelect",
		  					  type:"post",
		  					  success: function(data){
		  						  $("#school5").empty();
		  						  data.forEach(function(item,index){
									  $("#school5").append("<option onclick='"+"selectfive1("+hh+")'>"+item+"</option>");
		  						  });
		  						  
		  					  }
		  				  });
		  			  }
		  }
  function  selectfive1(hh){
		  			 var  school5=document.getElementById("school5").value;
		  			 var  specialty5=document.getElementById("specialty5").value;
		  			 if(school5!="请选择学校"){
		  				 if(specialty5=="请选择专业"){
		  					 $.ajax({
		  					 		 url:"/volunteer/target",
		  							 type:"post",
		  					 		 data:{schoolname: school5,specialtyClass: hh},
		  					 		 success: function(twodata){
		  					 			 $("#specialty5").empty();
		  					 			 twodata.forEach(function(i,t){
		  					 				 $("#specialty5").append("<option>"+i+"</option>");
		  					 			 });
		  					 		 }
		  					 });
		  				 }
		  				 else{
		  				 					 $.ajax({
		  				 						 url:"/volunteer/target",
		  										 type:"post",
		  				 						 data:{schoolname: school5,specialtyClass: hh},
		  				 						 success: function(twodata){
		  				 							 $("#specialty5").empty();
		  				 							 twodata.forEach(function(i,t){
		  				 								 $("#specialty5").append("<option>"+i+"</option>");
		  				 							 });
		  				 						 }
		  				 					 });
		  				 }
		  			 }else{
		  				 alert("请先选择学校");
		  			 }
		  }  