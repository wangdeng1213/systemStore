function gotoAdd(url) {
	window.location.href = url;
}
function getCheckedValues(checkedName) {
	var data = "";
	$("input:checkbox[name='" + checkedName + "']:checked").each(function() {
		data = data + this.value + ",";
	});
	return data.substring(0, data.length - 1);
}