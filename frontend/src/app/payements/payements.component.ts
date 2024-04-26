import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-payements',
  templateUrl: './payements.component.html',
  styleUrls: ['./payements.component.css']
})
export class PayementsComponent implements OnInit{
  public payements:any;
  public dataSource:any;
  displayedColumns: string[] = ['id', 'date', 'amount', 'type', 'status', 'firstName'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!:MatSort;

  constructor(private http: HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:8021/payements").subscribe(
      {
        next: data=>{
          this.payements = data;
          this.dataSource = new MatTableDataSource(this.payements);
          this.dataSource.paginator = this.paginator
          this.dataSource.sort = this.sort

        },
        error: err =>{
          console.log(err)
        }
      }
    )
  }

}
