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
    public class ChildEventsController : ApiController
    {
        private Entities4 db = new Entities4();

        // GET: api/ChildEvents
        public IQueryable<CHILD_EVENT> GetCHILD_EVENT()
        {
            return db.CHILD_EVENT;
        }

        // GET: api/ChildEvents/5
        [ResponseType(typeof(CHILD_EVENT))]
        public IHttpActionResult GetCHILD_EVENT(int id)
        {
            CHILD_EVENT cHILD_EVENT = db.CHILD_EVENT.Find(id);
            if (cHILD_EVENT == null)
            {
                return NotFound();
            }

            return Ok(cHILD_EVENT);
        }

        // PUT: api/ChildEvents/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCHILD_EVENT(int id, CHILD_EVENT cHILD_EVENT)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != cHILD_EVENT.CHILD_EVENT_ID)
            {
                return BadRequest();
            }

            db.Entry(cHILD_EVENT).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CHILD_EVENTExists(id))
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

        // POST: api/ChildEvents
        [ResponseType(typeof(CHILD_EVENT))]
        public IHttpActionResult PostCHILD_EVENT(CHILD_EVENT cHILD_EVENT)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.CHILD_EVENT.Add(cHILD_EVENT);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (CHILD_EVENTExists(cHILD_EVENT.CHILD_EVENT_ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = cHILD_EVENT.CHILD_EVENT_ID }, cHILD_EVENT);
        }

        // DELETE: api/ChildEvents/5
        [ResponseType(typeof(CHILD_EVENT))]
        public IHttpActionResult DeleteCHILD_EVENT(int id)
        {
            CHILD_EVENT cHILD_EVENT = db.CHILD_EVENT.Find(id);
            if (cHILD_EVENT == null)
            {
                return NotFound();
            }

            db.CHILD_EVENT.Remove(cHILD_EVENT);
            db.SaveChanges();

            return Ok(cHILD_EVENT);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool CHILD_EVENTExists(int id)
        {
            return db.CHILD_EVENT.Count(e => e.CHILD_EVENT_ID == id) > 0;
        }
    }
}