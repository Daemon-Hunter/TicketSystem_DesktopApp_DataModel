﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using API.Models;

namespace API.Controllers
{
    public class TicketsController : ApiController
    {
        private Entities10 db = new Entities10();

        // GET: api/Tickets
        public IQueryable<TICKET> GetTICKETs()
        {
            return db.TICKETs;
        }

        // GET: api/Tickets/5
        [ResponseType(typeof(TICKET))]
        public IHttpActionResult GetTICKET(int id)
        {
            TICKET tICKET = db.TICKETs.Find(id);
            if (tICKET == null)
            {
                return NotFound();
            }

            return Ok(tICKET);
        }

        // PUT: api/Tickets/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTICKET(int id, TICKET tICKET)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != tICKET.TICKET_ID)
            {
                return BadRequest();
            }

            db.Entry(tICKET).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TICKETExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Tickets
        [ResponseType(typeof(TICKET))]
        public IHttpActionResult PostTICKET(TICKET tICKET)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.TICKETs.Add(tICKET);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (TICKETExists(tICKET.TICKET_ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = tICKET.TICKET_ID }, tICKET);
        }

        // DELETE: api/Tickets/5
        [ResponseType(typeof(TICKET))]
        public IHttpActionResult DeleteTICKET(int id)
        {
            TICKET tICKET = db.TICKETs.Find(id);
            if (tICKET == null)
            {
                return NotFound();
            }

            db.TICKETs.Remove(tICKET);
            db.SaveChanges();

            return Ok(tICKET);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TICKETExists(int id)
        {
            return db.TICKETs.Count(e => e.TICKET_ID == id) > 0;
        }
    }
}