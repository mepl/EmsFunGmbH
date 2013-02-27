custom=function(){

// Erstellen jquery Tabs
		$(function() {        
		 $( "#tabs" ).tabs();   
		 });


		 
//Erstellen jquery Dialog
// Events
		$("#dialog").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    				$.ajax({
    					type:"GET",
    					url:"http://localhost:8080/EmsFunGmbH/EventServlet",
    					data: "bez=" + $("#bez").val() + "&bes=" + $("#bes").val() + "&kat="+ $("#kat").val() + "&ver=" + $("#ver").val(),
    					success: function(data){window.location.replace("index.jsp");},
    					error: function(){alert('Fehler');}
    				});
    		
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#dialog').dialog('open');
    });

//Erstellen jquery Dialog2
// Eventdaten
    
$("#dialog2").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    			$.ajax({
					type:"POST",
					url:"http://localhost:8080/EmsFunGmbH/EventDatenServlet",
					data: "preis=" + $("#preis").val() + "&beginn=" + $("#beginn").val() + "&ende="+ $("#ende").val() + "&sort=" + $("#sort").val()+ "&zort=" + $("#zort").val()+ "&mteilnehmer=" + $("#mteilnehmer").val()+ "&ateilnehmer=" + $("#ateilnehmer").val()+ "&frei=" + $("#frei").is(":checked")+ "&rabatt=" + $("#rabatt").val()+ "&vbenachrichtigt=" + $("#vbenachrichtigt").is(":checked"),
					success: function(data){window.location.replace("index.jsp");}
					
				});
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#dialog2').dialog('open');
    });

//Erstellen jquery Dialog3
// Kategorien		
		$("#dialog3").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    			$.ajax({
					type:"GET",
					url:"http://localhost:8080/EmsFunGmbH/EventKategorieServlet",
					data: "kbez=" + $("#kbez").val(),
					success: function(data){alert("Success");},
    				error: function(data){window.location = "http://localhost:8080/EmsFunGmbH/index.jsp";}
				});
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#dialog3').dialog('open');
    });
				
//Erstellen jquery Dialog4
		$("#dialog4").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    	              //$("#editdialog > form").submit();
    		  $(this).dialog('close');
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#dialog4').dialog('open');
    });
		
//Erstellen jquery Addbutton		
		
		$("#Add").click(function(){
		$("#dialog").dialog('open');
		return false;
				});
				
//Design jquery Addbutton		
				
		$("#Add").button();
		$("#Add").css('width', '170Px');
		$("#Add").css('height', '30Px');
		$("#Add").css('font-size', '10Px');
		
		
//Erstellen jquery AddEVbutton	
		$("#AddEV").click(function(){
		$("#dialog2").dialog('open');
		return false;
				});
				
//Design jquery AddEVbutton				
		$("#AddEV").button();
		$("#AddEV").css('width', '170Px');
		$("#AddEV").css('height', '30Px');
		$("#AddEV").css('font-size', '10Px');
		
		
//Erstellen jquery AddKbutton		
		$("#AddK").click(function(){
		$("#dialog3").dialog('open');
		return false;
				});

//Design jquery AddKbutton					
		$("#AddK").button();
		$("#AddK").css('width', '170Px');
		$("#AddK").css('height', '30Px');
		$("#AddK").css('font-size', '10Px');
		
//Erstellen jquery AddEVVbutton	
		$("#AddEVV").click(function(){
		$("#dialog4").dialog('open');
		return false;
				});

//Design jquery AddEVVbutton		
		$("#AddEVV").button();
		$("#AddEVV").css('width', '170Px');
		$("#AddEVV").css('height', '30Px');
		$("#AddEVV").css('font-size', '10Px');
		
//Erstellen jquery EditEventbutton
	
		$("#editEvent").click(function(){
		$("#editdialog").dialog('open');
		return false;
				});
				
		$("#editEvent2").click(function(){
		$("#editdialog").dialog('open');
		return false;
				});
				
		$("#editEvent3").click(function(){
		$("#editdialog").dialog('open');
		return false;
				});
				
		$("#editEvent4").click(function(){
		$("#editdialog").dialog('open');
		return false;
				});
				
		$("#editEvent5").click(function(){
		$("#editdialog").dialog('open');
		return false;
				});
				
		$("#editEV").click(function(){
		$("#editdialog2").dialog('open');
		return false;
				});
				
		$("#editEV2").click(function(){
		$("#editdialog2").dialog('open');
		return false;
				});
				
		$("#editEV3").click(function(){
		$("#editdialog2").dialog('open');
		return false;
				});
				
		$("#editEV4").click(function(){
		$("#editdialog2").dialog('open');
		return false;
				});
				
		$("#editEV5").click(function(){
		$("#editdialog2").dialog('open');
		return false;
				});
				
		$("#editK").click(function(){
		$("#editdialog3").dialog('open');
		return false;
				});
				
		$("#editK2").click(function(){
		$("#editdialog3").dialog('open');
		return false;
				});
				
		$("#editK3").click(function(){
		$("#editdialog3").dialog('open');
		return false;
				});
				
		$("#editK4").click(function(){
		$("#editdialog3").dialog('open');
		return false;
				});
				
		$("#editK5").click(function(){
		$("#editdialog3").dialog('open');
		return false;
				});
				
		$("#editEVV").click(function(){
		$("#editdialog4").dialog('open');
		return false;
				});
				
		$("#editEVV2").click(function(){
		$("#editdialog4").dialog('open');
		return false;
				});
				
		$("#editEVV3").click(function(){
		$("#editdialog4").dialog('open');
		return false;
				});
				
		$("#editEVV4").click(function(){
		$("#editdialog4").dialog('open');
		return false;
				});
				
		$("#editEVV5").click(function(){
		$("#editdialog4").dialog('open');
		return false;
				});
				
		
//Erstellen jquery Editdialog

 $("#editdialog").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    	              //$("#editdialog > form").submit();
    		  $(this).dialog('close');
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#editdialog').dialog('open');
    });
	
	$("#editdialog2").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    	              //$("#editdialog > form").submit();
    		  $(this).dialog('close');
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#editdialog2').dialog('open');
    });
	
	$("#editdialog3").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    	              //$("#editdialog > form").submit();
    		  $(this).dialog('close');
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#editdialog3').dialog('open');
    });
	
	$("#editdialog4").dialog({
    	bgiframe: true,
    	autoOpen: false,
    	width: 600,
    	
    	buttons: {
    		OK: function() {
    	              //$("#editdialog > form").submit();
    		  $(this).dialog('close');
    		},
    		Abbrechen: function() {
    			$(this).dialog('close');
    		}
    	}
    });
    $('#benutzerDel').click(function() {
    	$('#editdialog4').dialog('open');
    });
	
	
	$(".datepicker").datepicker({dateFormat: 'dd.mm.yy'});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
				
	/*	$("#editdialog2").dialog({
		autoOpen: false,
		width:600 });
						
		$("#editdialog_link2").click(function(){
		$("#editdialog2").dialog('open');
		return false;
				});
				
		$("#editdialog_link30").click(function(){
		$("#editdialog2").dialog('close');
		return false;
				});
				
		$("#editdialog3").dialog({
		autoOpen: false,
		width:600 });
						
		$("#editdialog_link3").click(function(){
		$("#editdialog3").dialog('open');
		return false;
				});
				
		$("#editdialog_link5").click(function(){
		$("#editdialog3").dialog('close');
		return false;
				});
				
		$("#editdialog4").dialog({
		autoOpen: false,
		width:600 });
						
		$("#editdialog_link4").click(function(){
		$("#editdialog4").dialog('open');
		return false;
				});
				
		$("#editdialog_link6").click(function(){
		$("#editdialog4").dialog('close');
		return false;
				});*/
				
		
}

