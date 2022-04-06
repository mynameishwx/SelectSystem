  function  selectone(){
			  var  school1=document.getElementById("school1").value;
			  if(school1!="请选择学校"){
				 
			  }else{
				  $.ajax({
					  url:"/school/SchoolSelect",
					  type:"post",
					  success: function(data){
						  $("#select1").empty();
						  data.forEach(function(item,index){
							  $("#school1").append("<option onclick='selectone1()'>"+item+"</option>");
						  });
						  
					  }
				  });
			  }
		  }
		  function  selectone1(){
			 var  school1=document.getElementById("school1").value;
			 var  specialty=document.getElementById("specialty").value;
			 if(school1!="请选择学校"){
				 if(specialty=="请选择专业"){
					 $.ajax({
					 		 url:"/volunteer/target",
							 type:"post",
					 		 data:{schoolname: school1,specialtyClass: [[${loginUser.sex}]]},
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
				 						 data:{schoolname: school1,specialtyClass: [[${loginUser.sex}]]},
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
		  
		  function  selecttwo(){
		  			  var  school2=document.getElementById("school2").value;
		  			  if(school2!="请选择学校"){
		  				 
		  			  }else{
		  				  $.ajax({
		  					  url:"/school/SchoolSelect",
		  					  type:"post",
		  					  success: function(data){
		  						  $("#select1").empty();
		  						  data.forEach(function(item,index){
		  							  $("#school2").append("<option onclick='selecttwo1()'>"+item+"</option>");
		  						  });
		  						  
		  					  }
		  				  });
		  			  }
		  }
		  function  selecttwo1(){
		  			 var  school2=document.getElementById("school2").value;
		  			 var  specialty2=document.getElementById("specialty2").value;
		  			 if(school2!="请选择学校"){
		  				 if(specialty2=="请选择专业"){
		  					 $.ajax({
		  					 		 url:"/volunteer/target",
		  							 type:"post",
		  					 		 data:{schoolname: school2,specialtyClass: [[${loginUser.sex}]]},
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
		  				 						 data:{schoolname: school2,specialtyClass: [[${loginUser.sex}]]},
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