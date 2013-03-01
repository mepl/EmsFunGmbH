
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="servlets.EventVeranstalterServlet"%>
<%@page import="servlets.EventKategorieServlet"%>
<%@page import="servlets.EventDatenServlet"%>
<%@page import="servlets.EventServlet"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>Eventmanagementsystem</title>
	<script type="text/javascript" src="js/custom.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="jquery-ui-1.9.1.custom/js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="jquery-ui-1.9.1.custom/js/jquery-ui-1.9.1.custom.js"></script>
	<script type="text/javascript" src="jquery-ui-1.9.1.custom/js/jquery-ui-1.9.1.custom.min.js"></script>
	<link rel="stylesheet" type="text/css" href="jquery-ui-1.9.1.custom/css/smoothness/jquery-ui-1.9.1.custom.css">
	</head>
	<body onload="custom();">
		<div class="header">Eventmanagementsystem<img src="images/logo.jpg" id="logo"></div>
		<div class="main">
			<div id="tabs">
				<ul>
					<li><a href="#tab-1">Event</a></li>
					<li><a href="#tab-2">Kategorien</a></li>
					<li><a href="#tab-3">Eventveranstalter</a></li>
				</ul>
				<div id="tab-1">
					<br>
					<div class="overview">
						Events
						<button class="add" id="Add">+ Add Event</button>
					</div>
					<br>
					<div class="scroll">
						<table id="Eventtable">
							<tr>
								<th style="border:1px solid purple">Veranstalter</th>
								<th style="border:1px solid purple">Kategorie</th>
								<th style="border:1px solid purple">Bezeichnung</th>
								<th style="border:1px solid purple">Beschreibung</th>
								<th style="width: 8%;"></th>
							</tr>
							<%
								EventServlet event = new EventServlet();
								out.print(event.getEventTable());
							%>
						</table>
					</div>
					<br>
					<div class="overview">
						Eventdaten
						<button class="add" id="AddEV">+ Add Eventdaten</button>
					</div>
					<br>
					<div class="scroll">
						<table id="Eventdatentable">
							<tr>
								<th style="border:1px solid purple">Event</th>
								<th style="border:1px solid purple">Preis</th>
								<th style="border:1px solid purple">Beginn</th>
								<th style="border:1px solid purple">Ende</th>
								<th style="border:1px solid purple">Startort</th>
								<th style="border:1px solid purple">Zielort</th>
								<th style="border:1px solid purple">Max. Teiln.</th>
								<th style="border:1px solid purple">Akt. Teiln.</th>
								<th style="border:1px solid purple">Freigegeben</th>
								<th style="border:1px solid purple">Rabatt</th>
								<th style="border:1px solid purple">Veranst. benachrichtigt</th>
								<th style="width:8%;"></th>
							</tr>
							<%
								EventDatenServlet eventdaten = new EventDatenServlet();
								out.print(eventdaten.getEventDatenTable());
							%>
						</table>
					</div>
				</div>
				<div id="tab-2">
					<br>
						<div class="overview">
							Kategorien
							<button class="add" id="AddK">+ Add Kategorie</button>
						</div>
					<br>
					<table id="Kategorientable">
						<tr>
							<th style="border:1px solid purple">Kategoriebezeichnung</th>
							<th style="width: 8%;"></th>
						</tr>
						<%
							EventKategorieServlet kategorie = new EventKategorieServlet();
							out.print(kategorie.getEventKategorieTable());
						%>
					</table>
					</div>
				<div id="tab-3">
					<br>
					<div class="overview">
						Eventveranstalter
						<button class="add" id="AddEVV">+ Add Eventveranstalter</button>
					</div>
					<br>
					<table id="Eventveranstaltertable">
						<tr>
							<th style="border:1px solid purple">Firma</th>
							<th style="border:1px solid purple">Strasse</th>
							<th style="border:1px solid purple">PLZ</th>
							<th style="border:1px solid purple">Hnummer</th>
							<th style="border:1px solid purple">Ort</th>
							<th style="border:1px solid purple">Telefon</th>
							<th style="border:1px solid purple">Email</th>
							<th style="border:1px solid purple">Fax</th>
							<th style="width: 5%;"></th>
						</tr>
						<%
							EventVeranstalterServlet veranstalterServlet = new EventVeranstalterServlet();
							out.print(veranstalterServlet.getEventVeranstalterTable());
						%>
					</table>
				</div>
			</div>
		</div>
		<div class="footer">Designed by Markus Zinngisser und Michael Brandhuber</div>
		<div id="dialog" title="Event eintragen">
			<table>
				<tr><td>Veranstalter:</td><td><select style="width:30;" id="ver" size="1">
				<% 
					EventServlet evComboServlet = new EventServlet();
					out.print(evComboServlet.getEventVeranstalter());
				%>
				</select></td></tr>
				<tr><td>Kategorie:</td><td><select style="width:30;" id="kat" size="1">
				<% 
					EventServlet kategorieComboServlet = new EventServlet();
					out.print(kategorieComboServlet.getEventKategorie());
				%>
				</select></td></tr>
				<tr><td>Bezeichnung:</td><td><input type="text" id="bez"></td></tr>
				<tr><td>Beschreibung:</td><td><input type="text" id="bes"></td></tr>
			</table>
		</div>
		<div id="editdialog" title="Event bearbeiten">
			<table>
				<tr><td>Veranstalter:</td><td><select style="width:30;" id="verEdit" size="1">
				<% 
					EventServlet evComboEditServlet = new EventServlet();
					out.print(evComboEditServlet.getEventVeranstalter());
				%>
				</select></td></tr>
				<tr><td>Kategorie:</td><td><select style="width:30;" id="katEdit" size="1">
				<% 
					EventServlet kategorieComboEditServlet = new EventServlet();
					out.print(kategorieComboEditServlet.getEventKategorie());
				%>
				</select></td></tr>
				<tr><td>Bezeichnung:</td><td><input type="text" id="bezEdit"></td></tr>
				<tr><td>Beschreibung:</td><td><input type="text" id="besEdit"></td></tr>
			</table>
		</div>
		<div id="dialog2" title="Eventdaten eintragen">
			<table>
				<tr><td>Veranstalter:</td><td><select style="width:30;" id="ver" size="1">
				<% 
					EventDatenServlet evDatenComboServlet = new EventDatenServlet();
					out.print(evDatenComboServlet.getEvents());
				%>
				</select></td></tr>
				<tr><td>Preis:</td><td><input type="text" id="preis"></td></tr>
				<tr><td>Beginn:</td><td><input class="datepicker" id="beginn"></td></tr>
				<tr><td>Ende:</td><td><input class="datepicker" id="ende"></td></tr>
				<tr><td>Startort:</td><td><input type="text" id="sort"></td></tr>
				<tr><td>Zielort:</td><td><input type="text" id="zort"></td></tr>
				<tr><td>MaxTeilnehmer:</td><td><input type="text" id="mteilnehmer"></td></tr>
				<tr><td>AktTeilnehmer:</td><td><input type="text" id="ateilnehmer"></td></tr>
				<tr><td>Freigegeben:</td><td><input type="checkbox" value="true" id="frei"></td></tr>
				<tr><td>Rabatt:</td><td><input type="text" id="rabatt"></td></tr>
				<tr><td>Veranstalter Benachrichtigt:</td><td><input type="checkbox" value="true" id="vbenachrichtigt"></td></tr>
			</table>
		</div>
		<div id="editdialog2" title="Eventdaten bearbeiten">
			<table>
				<tr><td>Preis:</td><td><input type="text" id="preisEdit"></td></tr>
				<tr><td>Beginn:</td><td><input type="text" id="beginnEdit"></td></tr>
				<tr><td>Ende:</td><td><input type="text" id="endeEdit"></td></tr>
				<tr><td>StartOrt:</td><td><input type="text" id="sortEdit"></td></tr>
				<tr><td>ZielOrt:</td><td><input type="text" id="zort"></td></tr>
				<tr><td>MaxTeilnehmer:</td><td><input type="text" id="mteilnehmerEdit"></td></tr>
				<tr><td>AktTeilnehmer:</td><td><input type="text" id="ateilnehmerEdit"></td></tr>
				<tr><td>Freigegeben:</td><td><input type="checkbox" id="freiEdit"></td></tr>
				<tr><td>Rabatt:</td><td><input type="text" id="rabattEdit"></td></tr>
				<tr><td>VeranstalterBenachrichtigt:</td><td><input type="checkbox" value="true" id="vbenachrichtigtEdit"></td></tr>
			</table>
		</div>
		<div id="dialog3" title="Kategorien eintragen">
			<table>
				<tr><td>Kategoriebezeichnung:</td><td><input type="text" id="kbez"></td></tr>
			</table>
		</div>
		<div id="editdialog3" title="Kategorien bearbeiten">
			<table>
				<tr><td>KategorieBezeichnung:</td><td><input type="text" id="kbezEdit"></td></tr>
			</table>
		</div>
		<div id="dialog4" title="Eventveranstalter eintragen">
			<table>
				<tr><td>Firma:</td><td><input type="text" id="firma"></td></tr>
				<tr><td>Strasse:</td><td><input type="text" id="strasse"></td></tr>
				<tr><td>PLZ:</td><td><input type="text" id="plz"></td></tr>
				<tr><td>HNummer:</td><td><input type="text" id="hnummer"></td></tr>
				<tr><td>Ort:</td><td><input type="text" id="ort"></td></tr>
				<tr><td>Telefon:</td><td><input type="text" id="tel"></td></tr>
				<tr><td>EMail:</td><td><input type="text" id="mail"></td></tr>
				<tr><td>Fax:</td><td><input type="text" id="fax"></td></tr>
			</table>
		</div>
		<div id="editdialog4" title="Eventveranstalter bearbeiten">
			<table>
				<tr><td>Firma:</td><td><input type="text" id="firmaEdit"></td></tr>
				<tr><td>Strasse:</td><td><input type="text" id="strasseEdit"></td></tr>
				<tr><td>PLZ:</td><td><input type="text" id="plzEdit"></td></tr>
				<tr><td>HNummer:</td><td><input type="text" id="hnummerEdit"></td></tr>
				<tr><td>Ort:</td><td><input type="text" id="ortEdit"></td></tr>
				<tr><td>Telefon:</td><td><input type="text" id="telEdit"></td></tr>
				<tr><td>EMail:</td><td><input type="text" id="mailEdit"></td></tr>
				<tr><td>Fax:</td><td><input type="text" id="faxEdit"></td></tr>
			</table>
		</div>
	</body>
</html>