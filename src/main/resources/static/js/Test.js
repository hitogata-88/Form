$(document).ready( function () {

	var table = $('#myTable').DataTable({
		'paging'      : true,
		'pageLength'  : 5,
		'lengthChange': true,
		'searching'   : true,
		'ordering'    : true,
		'info'        : true,
		'autoWidth'   : false,
		'scrollX'     : true,
		'scrollY'     : true,
		'order'       : [[ 0, 'asc' ]],
		'columnDefs'  : [
			{ targets: 0, width: 100, 'orderDataType' : 'custom'},
			{ targets: 1, width: 100 },
			{ targets: 2, width: 100 },
			{ targets: 3, width: 100 },
			{ targets: 4, width: 100 },
			{ targets: 5, width: 100 },
		],
		 "language"   : {
			"decimal":        ".",
			"emptyTable":     "表示するデータがありません。",
			"info":           "_START_ ～ _END_ / _TOTAL_ 件中",
			"infoEmpty":      "0 ～ 0 / 0 件",
			"infoFiltered":   "(合計 _MAX_ 件からフィルタリングしています)",
			"infoPostFix":    "",
			"thousands":      ",",
			"lengthMenu":     "1ページ _MENU_ 件を表示する",
			"loadingRecords": "読み込み中...",
			"processing":     "処理中...",
			"search":         "絞り込み:",
			"zeroRecords":    "一致するデータが見つかりません。",
			"paginate": {
				"first":      "最初",
				"last":       "最後",
				"next":       "次",
				"previous":   "前"
			}
		}
	});

	$("#addButton").on("click", function(event){
		var tr = $("<tr>");
		var td = "";
		td += "<td>5</td>"
		td += "<td>こなつ</td>"
		td += "<td>♀</td>"
		td += "<td>6</td>"
		td += "<td>01</td>"
		td += "<td>ふとん</td>"

		tr.append(td);
		table.row.add(tr).draw(false);

	});

});