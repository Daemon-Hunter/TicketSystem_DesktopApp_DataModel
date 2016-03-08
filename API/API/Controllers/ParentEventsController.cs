using System;
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
    public class ParentEventsController : ApiController
    {
        private Entities8 db = new Entities8();

        // GET: api/ParentEvents
        public IQueryable<PARENT_EVENT> GetPARENT_EVENT()
        {
            return db.PARENT_EVENT;
        }

        // GET: api/ParentEvents/5
        [ResponseType(typeof(PARENT_EVENT))]
        public IHttpActionResult GetPARENT_EVENT(int id)
        {
            PARENT_EVENT pARENT_EVENT = db.PARENT_EVENT.Find(id);
            if (pARENT_EVENT == null)
            {
                return NotFound();
            }

            return Ok(pARENT_EVENT);
        }

        // PUT: api/ParentEvents/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPARENT_EVENT(int id, PARENT_EVENT pARENT_EVENT)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != pARENT_EVENT.PARENT_EVENT_ID)
            {
                return BadRequest();
            }

            db.Entry(pARENT_EVENT).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PARENT_EVENTExists(id))
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

        // POST: api/ParentEvents
        [ResponseType(typeof(PARENT_EVENT))]
        public IHttpActionResult PostPARENT_EVENT(PARENT_EVENT pARENT_EVENT)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.PARENT_EVENT.Add(pARENT_EVENT);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (PARENT_EVENTExists(pARENT_EVENT.PARENT_EVENT_ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = pARENT_EVENT.PARENT_EVENT_ID }, pARENT_EVENT);
        }

        // DELETE: api/ParentEvents/5
        [ResponseType(typeof(PARENT_EVENT))]
        public IHttpActionResult DeletePARENT_EVENT(int id)
        {
            PARENT_EVENT pARENT_EVENT = db.PARENT_EVENT.Find(id);
            if (pARENT_EVENT == null)
            {
                return NotFound();
            }

            db.PARENT_EVENT.Remove(pARENT_EVENT);
            db.SaveChanges();

            return Ok(pARENT_EVENT);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PARENT_EVENTExists(int id)
        {
            return db.PARENT_EVENT.Count(e => e.PARENT_EVENT_ID == id) > 0;
        }
    }
}